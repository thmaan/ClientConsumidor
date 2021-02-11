package com.example.clientconsumidor;
import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface JsonPlaceHolderApi {

    @GET("dados")
    Call<List<DadoAdapter>> getDados();

    @GET("dados")
    Call<Results> getDado();

    @POST("dados-filtrados")
    Call<Results> getDadoFiltradoById(@Body Dado dados);

    @POST("dados-filtrados-datahora")
    Call<Results> getDadoFiltradoDatahora(@Body Dado dados);
}
