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

public class ExibirPokemonsActivity extends AppCompatActivity {
    private Pokemon pokemon;
    private List<Pokemon> pokemons;
    ListView ListaPokemons;
    EditText edtBusca;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exibir_pokemons);
        ListaPokemons = findViewById(R.id.ListaPokemons);


    }

    @Override
    protected void onResume() {
        super.onResume();
    this.preencherLista();
    }

    private void preencherLista(){
        pokemons = BaseDados.rPokemon.find(FindOptions.sort("nome", SortOrder.Ascending)).toList();
        ListAdapter adapter = new ArrayAdapter<Pokemon>(this, android.R.layout.simple_list_item_1, pokemons);
        ListaPokemons.setAdapter(adapter);

        ListaPokemons.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                pokemon = pokemons.get(i);
                enviarDados(pokemon);

            }
        });
    }
    public void enviarDados(Pokemon p){
        Intent i = new Intent(this,AtualizarPokemonActivity.class);
        i.putExtra("pokemon",p);
        startActivity(i);
    }

}