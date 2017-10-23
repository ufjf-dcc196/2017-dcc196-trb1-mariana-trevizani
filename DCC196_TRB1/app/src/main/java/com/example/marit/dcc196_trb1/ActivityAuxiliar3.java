package com.example.marit.dcc196_trb1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class ActivityAuxiliar3 extends AppCompatActivity {
    private EditText edtTitulo;
    private EditText edtEditora;
    private EditText edtAno;
    private Button btnCadastroLivro;
    private List<String> livros = new ArrayList<>();
    private List<String> editora = new ArrayList<>();
    private List<String> ano = new ArrayList<>();
    private String titulo;
    private Button btnListaLivro;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_auxiliar3);

        edtTitulo = (EditText) findViewById(R.id.edtTitulo);
        edtAno = (EditText) findViewById(R.id.edtAno);
        edtEditora = (EditText) findViewById(R.id.edtEditora);
        btnCadastroLivro = (Button) findViewById(R.id.btnCadastroLivro);
        btnListaLivro = (Button) findViewById(R.id.btnListaLivros);

        btnCadastroLivro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                livros.add(edtTitulo.getText().toString());
                editora.add(edtEditora.getText().toString());
                ano.add(edtAno.getText().toString());
                Toast.makeText(getApplicationContext(),"Livro cadastrado com sucesso!", Toast.LENGTH_SHORT).show();
            }
        });
        btnListaLivro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                titulo = edtTitulo.getText().toString();
                Intent intent = new Intent(ActivityAuxiliar3.this, ActivityAuxiliar4.class);
                Bundle dados = new Bundle();
                dados.putString("titulo", titulo);
                intent.putExtras(dados);
                startActivity(intent);
            }
        });
    }
}
