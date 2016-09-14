package com.example.aluno.projetoanimals.modelo;

import com.orm.SugarRecord;

import java.util.Date;

/**
 * Created by Aluno on 16/06/2016.
 */
public class Adocao extends SugarRecord {
    private String nomeAnimal;
    private String cpfAnunciante;
    private String descricao;
    private String nomeAnunciante;
    private String informacaoContato;
    private String especie;
    private String sexo;
    private String porte;
    private Double peso;
    private Integer idade;
    private String pelagem;
    private String raca;
    private String castrado;
    private String linkVideo;
    private String dataCadastro;
    private String cidade;
    private String fotoAdocao;

    public Adocao() {
    }



    public String getNome() {
        return nomeAnimal;
    }

    public void setNome(String nome) {
        this.nomeAnimal = nome;
    }

    public String getCpfAnunciante() {
        return cpfAnunciante;
    }

    public void setCpfAnunciante(String cpfAnunciante) {
        this.cpfAnunciante = cpfAnunciante;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getNomeAnunciante() {
        return nomeAnunciante;
    }

    public void setNomeAnunciante(String nomeAnunciante) {
        this.nomeAnunciante = nomeAnunciante;
    }

    public String getInformacaoContato() {
        return informacaoContato;
    }

    public void setInformacaoContato(String informacaoContato) {
        this.informacaoContato = informacaoContato;
    }

    public String getEspecie() {
        return especie;
    }

    public void setEspecie(String especie) {
        this.especie = especie;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getPorte() {
        return porte;
    }

    public void setPorte(String porte) {
        this.porte = porte;
    }

    public Double getPeso() {
        return peso;
    }

    public void setPeso(Double peso) {
        this.peso = peso;
    }

    public Integer getIdade() {
        return idade;
    }

    public void setIdade(Integer idade) {
        this.idade = idade;
    }

    public String getPelagem() {
        return pelagem;
    }

    public void setPelagem(String pelagem) {
        this.pelagem = pelagem;
    }

    public String getRaca() {
        return raca;
    }

    public void setRaca(String raca) {
        this.raca = raca;
    }

    public String getCastrado() {
        return castrado;
    }

    public void setCastrado(String castrado) {
        this.castrado = castrado;
    }

    public String getLinkVideo() {
        return linkVideo;
    }

    public void setLinkVideo(String linkVideo) {
        this.linkVideo = linkVideo;
    }

    public String getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(String dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }
}
