package com.smash.pokeapp;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class CadastrarTreinadores extends AppCompatActivity {

    public EditText edtNomeTreinador, edtGeneroTreinador, edtIdadeTreinador, edtRegiaoTreinador;
    public  Treinador treinador = new Treinador();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastrar_treinadores);

        edtNomeTreinador = findViewById(R.id.editTextNomeCadTreinador);
        edtGeneroTreinador = findViewById(R.id.editTextGeneroCadTreinador);
        edtIdadeTreinador = findViewById(R.id.editTextIdadeCadTreinador);
        edtRegiaoTreinador = findViewById(R.id.editTextRegiaoCadTreinador);

//        BaseDados.init(getFilesDir().getPath());

    }

    public void cadastrarTreinador(View view){
        String mensagem = "";

        try{
            treinador.setNome(edtNomeTreinador.getText().toString());
            treinador.setGenero(edtGeneroTreinador.getText().toString());
            treinador.setIdade(Integer.parseInt(edtIdadeTreinador.getText().toString()));
            treinador.setRegiao(edtRegiaoTreinador.getText().toString());
            treinador.setEspecialidade("Grama");

            BaseDados.rTreinador.insert(treinador);
            limpaInformacoes();

            mensagem = "Treinador cadastrado com sucesso!";
        }catch(Exception ex){
            mensagem = "Erro ao cadastrar treinador. Tente novamente mais tarde.";
        }

        new AlertDialog.Builder(this)
                .setMessage(mensagem)
                .setTitle("Mensagem")
                .setIcon(R.drawable.insignia_pokemon)
                .setPositiveButton("Ok", null)
                .show();

    }

    private void limpaInformacoes() {
        edtNomeTreinador.setText("");
        edtGeneroTreinador.setText("");
        edtIdadeTreinador.setText("");
        edtRegiaoTreinador.setText("");
        treinador = new Treinador();
    }

}