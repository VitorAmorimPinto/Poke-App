package com.smash.pokeapp;

import org.dizitart.no2.Nitrite;
import org.dizitart.no2.NitriteId;
import org.dizitart.no2.objects.Id;

import java.io.Serializable;

public class Pokemon implements Serializable {
    @Id
    public NitriteId id;
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

    @Override
    public String toString() {
        return
                "Nome: " + nome + " | " +
                        "Peso: " + peso + " | "+
                        "Tipo: " + tipo +  " | " +
                        "Espécie: " + especie +  " | " +
                        "Habilidade: " + habilidade +  " | "

                ;
    }

}
