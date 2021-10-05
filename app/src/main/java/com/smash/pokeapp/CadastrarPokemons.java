package com.smash.pokeapp;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class CadastrarPokemons extends AppCompatActivity {
    public EditText edtNomePokemon, edtPesoPokemon, edtTipoPokemon, edtEspeciePokemon, edtHabilidadePokemon;
    public  Pokemon pokemon = new Pokemon();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastrar_pokemons);

        edtNomePokemon = findViewById(R.id.editTextNomeCadPokemon);
        edtPesoPokemon = findViewById(R.id.edtPesoPokemon);
        edtTipoPokemon = findViewById(R.id.editTextTipoCadPokemon);
        edtEspeciePokemon = findViewById(R.id.editTextEspecieCadPokemon);
        edtHabilidadePokemon = findViewById(R.id.editTextHabilidadeCadPokemon);
    }
    public void cadastrarPokemon(View view){
        String mensagem = "";

        try{
            pokemon.setNome(edtNomePokemon.getText().toString());
            pokemon.setPeso(Double.parseDouble(edtPesoPokemon.getText().toString()));
            pokemon.setTipo(edtTipoPokemon.getText().toString());
            pokemon.setEspecie(edtEspeciePokemon.getText().toString());
            pokemon.setHabilidade(edtHabilidadePokemon.getText().toString());

            BaseDados.rPokemon.insert(pokemon);
            limpaInformacoes();

            mensagem = "Pokémon cadastrado com sucesso!";
        }catch(Exception ex){
            mensagem = "Erro ao cadastrar pokémon. Tente novamente!";
        }

        new AlertDialog.Builder(this)
                .setMessage(mensagem)
                .setTitle("Mensagem")
                .setIcon(R.drawable.pokebola)
                .setPositiveButton("Ok", null)
                .show();

    }

    private void limpaInformacoes() {
        edtNomePokemon.setText("");
        edtPesoPokemon.setText("");
        edtTipoPokemon.setText("");
        edtEspeciePokemon.setText("");
        edtHabilidadePokemon.setText("");
        pokemon = new Pokemon();
    }
}