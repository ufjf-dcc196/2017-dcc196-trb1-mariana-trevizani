package com.example.marit.trb1_dcc196;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class ActivityListaLivros extends AppCompatActivity {
    private ListView lstLivros;
    private Button btnVoltar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_livros);

        lstLivros = (ListView) findViewById(R.id.lstLivros);
        btnVoltar = (Button) findViewById(R.id.btnVoltar);

        // Recebe o ArrayList de livros da Main
        ArrayList<Livro> livrosCadastrados = new ArrayList<Livro>();
        livrosCadastrados= (ArrayList<Livro>) getIntent().getSerializableExtra("listagem");

        final ArrayAdapter<Livro> adaptador = new ArrayAdapter<>(
                getApplicationContext(),
                android.R.layout.simple_list_item_1,
                android.R.id.text1,
                livrosCadastrados
        );
        lstLivros.setAdapter(adaptador);

        btnVoltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ActivityListaLivros.this,Main.class);
                startActivity(intent);
            }
        });
    }
}
