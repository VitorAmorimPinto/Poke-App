package com.smash.pokeapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

import org.dizitart.no2.FindOptions;
import org.dizitart.no2.SortOrder;
import org.dizitart.no2.objects.filters.ObjectFilters;

import java.util.List;

public class ExibeTreinadoresActivity extends AppCompatActivity {
    private Treinador treinador;
    private List<Treinador> treinadors;
    ListView ListaTreinadores;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exibe_treinadores);
        ListaTreinadores = findViewById(R.id.ListaTreinadores);
    }

    @Override
    protected void onResume() {
        super.onResume();
        this.preencherLista();
    }

    private void preencherLista(){
        treinadors = BaseDados.rTreinador.find(FindOptions.sort("nome", SortOrder.Ascending)).toList();
        ListAdapter adapter = new ArrayAdapter<Treinador>(this, android.R.layout.simple_list_item_1, treinadors);
        ListaTreinadores.setAdapter(adapter);

        ListaTreinadores.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                treinador = treinadors.get(i);
                enviarDados(treinador);

            }
        });

    }

    public void enviarDados(Treinador treinador){
        Intent i = new Intent(this,AttTreinadorActivity.class);
        i.putExtra("treinador",treinador);
        startActivity(i);
    }


}