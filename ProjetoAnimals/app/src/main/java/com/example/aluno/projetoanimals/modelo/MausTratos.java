package com.example.aluno.projetoanimals.modelo;

import com.orm.SugarRecord;

/**
 * Created by Aluno on 16/06/2016.
 */
public class MausTratos extends SugarRecord {

    private String descricaoAnimal;
    private String informacoesContato;
    private String cidade;
    private Double latitude;
    private Double longitude;
    private String fotoMausTratos;

    public MausTratos() {
    }

    public String getFotoMausTratos() {
        return fotoMausTratos;
    }

    public void setFotoMausTratos(String fotoMausTratos) {
        this.fotoMausTratos = fotoMausTratos;
    }

    public String getDescricaoAnimal() {
        return descricaoAnimal;
    }

    public void setDescricaoAnimal(String descricaoAnimal) {
        this.descricaoAnimal = descricaoAnimal;
    }

    public String getInformacoesContato() {
        return informacoesContato;
    }

    public void setInformacoesContato(String informacoesContato) {
        this.informacoesContato = informacoesContato;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }
}
