package com.example.clientconsumidor;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Dado {

    @SerializedName("datahora")
    @Expose
    private String datahora;
    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("luminosidade")
    @Expose
    private String luminosidade;
    @SerializedName("temperatura")
    @Expose
    private String temperatura;
    @SerializedName("umidade")
    @Expose
    private String umidade;

    public Dado(Integer id) {
        this.id = id;
    }

    public Dado(String datahora) {
        this.datahora = datahora;
    }

    public Dado(String datahora, Integer id, String luminosidade, String temperatura, String umidade) {
        this.datahora = datahora;
        this.id = id;
        this.luminosidade = luminosidade;
        this.temperatura = temperatura;
        this.umidade = umidade;
    }

    public String getDatahora() {
        return datahora;
    }

    public void setDatahora(String datahora) {
        this.datahora = datahora;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLuminosidade() {
        return luminosidade;
    }

    public void setLuminosidade(String luminosidade) {
        this.luminosidade = luminosidade;
    }

    public String getTemperatura() {
        return temperatura;
    }

    public void setTemperatura(String temperatura) {
        this.temperatura = temperatura;
    }

    public String getUmidade() {
        return umidade;
    }

    public void setUmidade(String umidade) {
        this.umidade = umidade;
    }

}