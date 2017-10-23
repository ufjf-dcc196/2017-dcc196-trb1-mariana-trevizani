package com.example.marit.dcc196_trb1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class ActivityAuxiliar1 extends AppCompatActivity {
    private Button btnCadastroAux;
    private EditText txtNome;
    private EditText txtEmail;
    private Button btnVoltar;
    private ArrayList<String> nomes = new ArrayList<String>();
    private String nome;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_auxiliar1);

        btnCadastroAux = (Button) findViewById(R.id.btnCadastroAux);
        txtNome = (EditText) findViewById(R.id.txtNome);
        txtEmail = (EditText) findViewById(R.id.txtEmail);
        btnVoltar = (Button) findViewById(R.id.btnVoltar);

        btnCadastroAux.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(),"Usuário cadastrado com sucesso!", Toast.LENGTH_SHORT).show();
            }
        });
        btnVoltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                nome = txtNome.getText().toString();
                Intent intent2 = new Intent(ActivityAuxiliar1.this, ActivityAuxiliar2.class);
                Bundle dados2 = new Bundle();
                dados2.putString("nome", nome);
                intent2.putExtras(dados2);

                startActivity(intent2);

            }
        });
    }

}
