package com.example.marit.dcc196_trb1;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private ListView lstNomes;
    private Button btnCadastro;
    private Button btnLivro;
    private Button btnReserva;
    private static final int PEDE_NOME = 1;
    private static ArrayList<String> nomes = new ArrayList<String>();
    private String mensagem;
    private Button btnLista;
String nome;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lstNomes = (ListView) findViewById(R.id.lstNomes);
        btnCadastro = (Button) findViewById(R.id.btnCadastro);
        btnLivro = (Button) findViewById(R.id.btnLivro);
        btnReserva = (Button) findViewById(R.id.btnReserva);
        btnLista = (Button) findViewById(R.id.btnLista);

        final ArrayAdapter<String> adaptador = new ArrayAdapter<String>(
                getApplicationContext(),
                android.R.layout.simple_list_item_1,
                android.R.id.text1,
                nomes
        );
        lstNomes.setAdapter(adaptador);

        btnCadastro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent pedirNome = new Intent(MainActivity.this, ActivityAuxiliar1.class);
                startActivityForResult(pedirNome, PEDE_NOME);
            }
        });
        btnLivro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent pedirLivro = new Intent(MainActivity.this, ActivityAuxiliar3.class);
                startActivityForResult(pedirLivro, PEDE_NOME);
            }
        });
        btnLista.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mensagem = getIntent().getStringExtra("nome");
                    adaptador.add(mensagem);
            }
        });
        btnReserva.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent2 = new Intent(MainActivity.this, ActivityAuxiliar2.class);
                Bundle dados2 = new Bundle();
                dados2.putString("nome", mensagem);
                intent2.putExtras(dados2);
                startActivity(intent2);

            }
        });
    }
}
