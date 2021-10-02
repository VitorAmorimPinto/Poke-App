package com.smash.pokeapp;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
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
    public void submit(View view) {
        String mensagem = "";
        p.setNome("" + edtNome.getText());
        p.setPeso(Double.parseDouble(String.valueOf(edtPeso.getText())));
        p.setTipo("" + edtTipo.getText());
        p.setEspecie("" + edtEspecie.getText());
        p.setHabilidade("" + edtHabilidade.getText());
        try {
            BaseDados.rPokemon.update(p);
            mensagem = "Pokémon atualizado com sucesso!";

        } catch (Exception ex) {
            mensagem = "Erro ao atualizar pokémon. Tente novamente mais tarde.";
        }

        AlertDialog.Builder alert = new AlertDialog.Builder(AtualizarPokemonActivity.this);
        alert.setTitle("Mensagem");
        alert.setMessage(mensagem);
        alert.setPositiveButton("Ok", new DialogInterface.OnClickListener() {

            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
                finish();
            }
        });
        alert.show();
    }

    public void excluir(View view){

        if(p != null){
            AlertDialog.Builder alert = new AlertDialog.Builder(AtualizarPokemonActivity.this);
            alert.setTitle("Excluir Pokémon");
            alert.setMessage("Deseja realmente excluir esse Pokémon?");
            alert.setPositiveButton("Sim", new DialogInterface.OnClickListener() {

                @Override
                public void onClick(DialogInterface dialog, int which) {
                    String mensagem = "";

                    try {
                        BaseDados.rPokemon.update(p);
                        mensagem = "Pokémon excluido com sucesso!";

                    } catch (Exception ex) {
                        mensagem = "Erro ao excluir pokémon. Tente novamente mais tarde.";
                    }
                    BaseDados.rPokemon.remove(p);
                    dialog.dismiss();

                    AlertDialog.Builder alerta = new AlertDialog.Builder(AtualizarPokemonActivity.this);
                    alerta.setTitle("Mensagem");
                    alerta.setMessage(mensagem);
                    alerta.setPositiveButton("Ok", new DialogInterface.OnClickListener() {

                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.dismiss();
                            finish();
                        }
                    });
                    alerta.show();
                }
            });

            alert.setNegativeButton("Não", new DialogInterface.OnClickListener() {

                @Override
                public void onClick(DialogInterface dialog, int which) {
                    dialog.dismiss();
                }
            });

            alert.show();
        }
    }


}