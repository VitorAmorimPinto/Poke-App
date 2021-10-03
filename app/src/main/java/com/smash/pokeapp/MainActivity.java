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

    public void abreTelaTreinador(View view) {
        startActivity(new Intent(this, CadastrarTreinadores.class));
    }

    public void abreTelaExibicao(View view) {
        startActivity(new Intent(this, ExibeTreinadoresActivity.class));
    }
}