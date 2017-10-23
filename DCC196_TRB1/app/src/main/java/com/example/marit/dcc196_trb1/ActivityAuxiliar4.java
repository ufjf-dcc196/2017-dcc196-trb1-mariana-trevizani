package com.example.marit.dcc196_trb1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class ActivityAuxiliar4 extends AppCompatActivity {
    private static ArrayList<String> titulos = new ArrayList<String>();
    private Button btnListagemPessoa;
    private ListView lstLivro;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_auxiliar2);

        btnListagemPessoa = (Button) findViewById(R.id.btnListagemPessoa);
        lstLivro = (ListView) findViewById(R.id.lstLivro);

        final ArrayAdapter<String> adaptadorP = new ArrayAdapter<String>(
                getApplicationContext(),
                android.R.layout.simple_list_item_1,
                android.R.id.text1,
                titulos
        );
        lstLivro.setAdapter(adaptadorP);
        btnListagemPessoa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String titulo = getIntent().getStringExtra("titulo");
                    adaptadorP.add(titulo);
            }
        });

    }
}
