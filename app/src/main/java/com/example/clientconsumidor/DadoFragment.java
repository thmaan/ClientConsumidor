package com.example.clientconsumidor;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.gson.JsonArray;

import java.io.DataOutput;
import java.util.ArrayList;
import java.util.List;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.Body;

import static java.sql.Types.INTEGER;
import static java.sql.Types.NULL;

public class DadoFragment extends Fragment {
    private View view;
    private DadoAdapter myAdapter;
    public List<Dado> list;
    private HttpLoggingInterceptor loggingInterceptor;
    private OkHttpClient okHttpClient;
    private Retrofit retrofit;
    private JsonPlaceHolderApi jsonPlaceHolderApi;
    public Dado d;
    private Bundle bundle;
    private String filterData;
    private int filterId;
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.dado_fragment ,container,false);
        RecyclerView recyclerView = view.findViewById(R.id.dados_list);
        recyclerView.setHasFixedSize(true);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this.getActivity());
        recyclerView.setLayoutManager(layoutManager);

        build();

        list = new ArrayList<>();

        if(getArguments() != null){
            filterId = getArguments().getInt("id");
            filterData = getArguments().getString("data");
            if(!(filterData == null)){
                getDadoFiltradoDatahora();
            }else
                getDadoFiltradoById();
        }else {
            getDado();
        }
        myAdapter = new DadoAdapter(list);
        recyclerView.setAdapter(myAdapter);

        return view;
    }
    public void getDado(){
        Call<Results> call = jsonPlaceHolderApi.getDado();
        call(call);
    }
    public void populateList(Response<Results> response){
        int id = response.body().getDados().getId();
        String luminosidade = response.body().getDados().getLuminosidade();
        String temperatura = response.body().getDados().getTemperatura();
        String umidade = response.body().getDados().getUmidade();
        String dataahora = response.body().getDados().getDatahora();
        Dado d = new Dado(dataahora, id, luminosidade, temperatura, umidade);
        list.add(d);
        myAdapter.notifyDataSetChanged();
    }
    public void call(Call<Results> call){
        call.enqueue(new Callback<Results>() {
            @Override
            public void onResponse(Call<Results> call, Response<Results> response) {
                if (!response.isSuccessful()) {
                    Toast.makeText(getActivity(), "Code: " + response.message(), Toast.LENGTH_SHORT).show();
                    return;
                }
                populateList(response);
            }
            @Override
            public void onFailure(Call<Results> call, Throwable t) {
                t.getCause();
                Toast.makeText(getActivity(), "failed bro", Toast.LENGTH_SHORT).show();
            }
        });

    }
    public void getDadoFiltradoDatahora(){
        Dado d = new Dado(filterData);
        Call<Results> call = jsonPlaceHolderApi.getDadoFiltradoDatahora(d);
        call(call);
     }
    public void getDadoFiltradoById(){
        Dado d = new Dado(filterId);
        Call<Results> call = jsonPlaceHolderApi.getDadoFiltradoById(d);
        call(call);
    }
    public void build() {
        loggingInterceptor = new HttpLoggingInterceptor();
        loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

        okHttpClient = new OkHttpClient.Builder()
                    .addInterceptor(loggingInterceptor)
                    .build();

        retrofit = new Retrofit.Builder()
                    .baseUrl("http://10.0.2.2:5000/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .client(okHttpClient)
                    .build();

        jsonPlaceHolderApi = retrofit.create(JsonPlaceHolderApi.class);
        }
}

