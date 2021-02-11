package com.example.clientconsumidor;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class DadoAdapter extends RecyclerView.Adapter<DadoAdapter.MyViewHolder> {
    private List<Dado> mData;

   public static class MyViewHolder extends RecyclerView.ViewHolder{
        TextView tv_id;
        TextView tv_temperatura;
        TextView tv_umidade;
        TextView tv_luminosidade;
        TextView tv_datahora;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            tv_id = itemView.findViewById(R.id.dado_id);
            tv_temperatura = itemView.findViewById(R.id.dado_temperatura);
            tv_umidade = itemView.findViewById(R.id.dado_umidade);
            tv_luminosidade = itemView.findViewById(R.id.dado_luminosidade);
            tv_datahora = itemView.findViewById(R.id.dado_datahora);

        }
    }
    public DadoAdapter(List<Dado> mData){
        this.mData = mData;
    }
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.cardview_dado, parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.tv_id.setText("Id: "+mData.get(position).getId());
        holder.tv_temperatura.setText("Temperatura: "+mData.get(position).getTemperatura()+"ºC");
        holder.tv_luminosidade.setText("Luminosidade: "+mData.get(position).getLuminosidade()+"lx");
        holder.tv_umidade.setText("Umidade: "+mData.get(position).getUmidade()+"g/Kg");
        holder.tv_datahora.setText("Data e Hora: "+mData.get(position).getDatahora());

    }

    @Override
    public int getItemCount() {
        return mData.size();
    }
}
