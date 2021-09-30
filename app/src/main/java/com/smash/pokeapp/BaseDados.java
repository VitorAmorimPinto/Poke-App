package com.smash.pokeapp;

import org.dizitart.no2.Nitrite;
import org.dizitart.no2.objects.ObjectRepository;

public class BaseDados {
    public static ObjectRepository<Pokemon> rPokemon;
    public static ObjectRepository<Treinador> rTreinador;

    public static void init(String dbPath){
        Nitrite db = Nitrite.builder()

                .compressed()

                .filePath(dbPath+"baseDados.db")

                .openOrCreate("root", "salesiano");
        rPokemon = db.getRepository(Pokemon.class);
        rTreinador = db.getRepository(Treinador.class);

    }
}
