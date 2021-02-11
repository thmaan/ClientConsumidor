package com.example.clientconsumidor;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Results {

    @SerializedName("dados")
    @Expose
    private Dado dados;

    public Dado getDados() {
        return dados;
    }

    public void setDados(Dado dados) {
        this.dados = dados;
    }

}