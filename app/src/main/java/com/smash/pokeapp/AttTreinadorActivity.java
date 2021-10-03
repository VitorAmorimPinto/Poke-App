package com.smash.pokeapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AlertDialog;


import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.content.DialogInterface;


public class AttTreinadorActivity extends AppCompatActivity {
    EditText edtNome, edtGenero, edtRegiao,edtTipo, edtIdade;
    Treinador treinador;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_att_treinador);
        Intent i = getIntent();
        treinador = (Treinador) i.getSerializableExtra("treinador");
        edtNome = findViewById(R.id.edtNome);
        edtGenero = findViewById(R.id.edtGenero);
        edtIdade = findViewById(R.id.edtIdade);
        edtTipo = findViewById(R.id.edtTipo);
        edtRegiao = findViewById(R.id.edtRegiao);
              Log.i("Dados: ", treinador.toString());
        this.preencherCampos();
    }

    public void preencherCampos(){
        edtNome.setText(treinador.getNome());
        edtIdade.setText(""+treinador.getIdade());
        edtTipo.setText(treinador.getEspecialidade());
        edtGenero.setText(treinador.getGenero());
        edtRegiao.setText(treinador.getRegiao());

    }

    public void salvarAtualizacao(View view){
        String mensagem = "";
        treinador.setNome("" + edtNome.getText());
        treinador.setEspecialidade("" + edtTipo.getText());
        treinador.setGenero("" + edtGenero.getText());
        treinador.setRegiao("" + edtRegiao.getText());
        treinador.setIdade(Integer.parseInt(String.valueOf(edtIdade.getText())));
        try {
            BaseDados.rTreinador.update(treinador);
            mensagem = "Treinador atualizado com sucesso!";

        } catch (Exception ex) {
            mensagem = "Erro ao atualizar treinador. Tente novamente mais tarde.";
        }
        AlertDialog.Builder alert = new AlertDialog.Builder(AttTreinadorActivity.this);
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
    public void excluirTreinador(View view){

        if(treinador != null){
            AlertDialog.Builder alert = new AlertDialog.Builder(AttTreinadorActivity.this);
            alert.setTitle("Excluir Treinador");
            alert.setMessage("Deseja realmente excluir esse Treinador?");
            alert.setPositiveButton("Sim", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    String mensagem = "";

                    try {
                        BaseDados.rTreinador.update(treinador);
                        mensagem = "Treinador excluido com sucesso!";

                    } catch (Exception ex) {
                        mensagem = "Erro ao excluir treinador. Tente novamente mais tarde.";
                    }
                    BaseDados.rTreinador.remove(treinador);
                    dialog.dismiss();

                    AlertDialog.Builder alerta = new AlertDialog.Builder(AttTreinadorActivity.this);
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