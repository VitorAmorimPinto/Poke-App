package com.smash.pokeapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class AtualizarPokemonActivity extends AppCompatActivity {
    EditText edtNome, edtPeso,edtTipo,edtEspecie,edtHabilidade;
    Pokemon p;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_atualizar_pokemon);
        Intent i = getIntent();
         p = (Pokemon)i.getSerializableExtra("pokemon");
        edtNome = findViewById(R.id.EdtNome);
        edtPeso = findViewById(R.id.EdtNPeso);
        edtTipo = findViewById(R.id.EdtTipo);
        edtEspecie = findViewById(R.id.EdtEspecie);
        edtHabilidade = findViewById(R.id.EdtHabilidade);
//        Log.i("Dados: ", p.toString());

        this.preencherCampos();



    }
    public void preencherCampos(){
        edtNome.setText(p.getNome());
        edtPeso.setText(""+p.getPeso());
        edtTipo.setText(p.getTipo());
        edtEspecie.setText(p.getEspecie());
        edtHabilidade.setText(p.getHabilidade());

    }
    public void submit(View view){
        p.setNome("" + edtNome.getText());
        p.setPeso(Double.parseDouble(String.valueOf(edtPeso.getText())));
        p.setTipo("" + edtTipo.getText());
        p.setEspecie("" + edtEspecie.getText());
        p.setHabilidade("" + edtHabilidade.getText());
    try {
        BaseDados.rPokemon.update(p);
        Toast.makeText(this, "Pokémon Atualizado com sucesso ", Toast.LENGTH_LONG).show();
        Intent i = new Intent(this,ExibirPokemonsActivity.class);
        startActivity(i);
    }catch (Exception ex){

    }


    }

}