package com.smash.pokeapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BaseDados.init(getFilesDir().getPath());

    }
    public void goToExibirPokemon(View view){
        Intent i = new Intent(this,ExibirPokemonsActivity.class);
        startActivity(i);
    }
    public void goToCadastrarTreinador(View view){
        Intent i = new Intent(this,CadastrarTreinadores.class);
        startActivity(i);
    }
    public void goToExibirTreinador(View view){
        Intent i = new Intent(this,ExibeTreinadoresActivity.class);
        startActivity(i);
    }
    public void goToCadastrarPokemon(View view){
        Intent i = new Intent(this,CadastrarPokemons.class);
        startActivity(i);
    }


}