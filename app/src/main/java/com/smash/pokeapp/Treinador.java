package com.smash.pokeapp;

public class Treinador {
    private String nome, especialidade, genero, regiao;
    private int idade;

    public Treinador() {
    }

    public Treinador(String nome, String especialidade, String genero, String regiao, int idade) {
        this.nome = nome;
        this.especialidade = especialidade;
        this.genero = genero;
        this.regiao = regiao;
        this.idade = idade;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEspecialidade() {
        return especialidade;
    }

    public void setEspecialidade(String especialidade) {
        this.especialidade = especialidade;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getRegiao() {
        return regiao;
    }

    public void setRegiao(String regiao) {
        this.regiao = regiao;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }
}
