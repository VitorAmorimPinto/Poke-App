package com.smash.pokeapp;

public class Pokemon {
    private String nome, tipo, especie, habilidade;
    private double peso;

    public Pokemon() {
    }

    public Pokemon(String nome, String tipo, String especie, String habilidade, double peso) {
        this.nome = nome;
        this.tipo = tipo;
        this.especie = especie;
        this.habilidade = habilidade;
        this.peso = peso;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getEspecie() {
        return especie;
    }

    public void setEspecie(String especie) {
        this.especie = especie;
    }

    public String getHabilidade() {
        return habilidade;
    }

    public void setHabilidade(String habilidade) {
        this.habilidade = habilidade;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }
}
