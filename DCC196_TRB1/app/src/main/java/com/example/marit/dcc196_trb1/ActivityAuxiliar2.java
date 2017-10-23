package com.example.marit.dcc196_trb1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class ActivityAuxiliar2 extends AppCompatActivity {
    private static final int PEDE_NOME = 1;
    private ListView lstPessoa;
    private static ArrayList<String> livros = new ArrayList<String>();
    private static ArrayList<String> nomes = new ArrayList<String>();
    private static ArrayList<String> horaEntrada = new ArrayList<>();
    private static ArrayList<String> horaSaida = new ArrayList<>();
    private Button btnListagem;
    private TextView txt;
    private String titulo;
    private Button btnLivro;
    String mensagem;
    private static int cont=0;
    private Button btnVoltar;
    private TextView txtSaida;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_auxiliar2);

        lstPessoa = (ListView) findViewById(R.id.lstLivro);
        btnListagem = (Button) findViewById(R.id.btnListagemPessoa);
        txt = (TextView) findViewById(R.id.txt);
        btnLivro = (Button) findViewById(R.id.btnLivro);
        btnVoltar = (Button) findViewById(R.id.btnVoltar);
        txtSaida = (TextView) findViewById(R.id.txtSaida);

        final ArrayAdapter<String> adaptador = new ArrayAdapter<String>(
                getApplicationContext(),
                android.R.layout.simple_list_item_1,
                android.R.id.text1,
                nomes
        );
        lstPessoa.setAdapter(adaptador);
        btnListagem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                 mensagem = getIntent().getStringExtra("nome");
                if(mensagem == null)
                    txt.setText(" ");
                else
                    adaptador.add(mensagem);
            }
        });
        btnLivro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent2 = new Intent(ActivityAuxiliar2.this, ActivityAuxiliar4.class);
                startActivity(intent2);
            }
        });
        lstPessoa.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
                String escolha = adaptador.getItem(i);
                if(horaEntrada.isEmpty()){
                    horaEntrada.add(pegaDataHora());
                    txt.setText(horaEntrada.get(i).toString());
                } else if (horaSaida.isEmpty()){
                    horaSaida.add(pegaDataHora());
                    txtSaida.setText(horaSaida.get(i).toString());
                }else if(!horaEntrada.isEmpty() && !horaSaida.isEmpty()){
                    horaEntrada.add(i," ");
                    horaSaida.add(i," ");
                    txt.setText(horaEntrada.get(i).toString());
                    txtSaida.setText(horaSaida.get(i).toString());
                }
                return false;
            }
        });
        btnVoltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nome = getIntent().getStringExtra("nome");
                Intent intent2 = new Intent(ActivityAuxiliar2.this, MainActivity.class);
                Bundle dados2 = new Bundle();
                dados2.putString("nome", nome);
                intent2.putExtras(dados2);

                startActivity(intent2);

            }
        });
    }

    public String pegaDataHora(){
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy-HH:mm:ss");
        // OU
        SimpleDateFormat dateFormat_hora = new SimpleDateFormat("HH:mm:ss");

        Date data = new Date();

        Calendar  cal = Calendar.getInstance();
        cal.setTime(data);
        Date data_atual = cal.getTime();

        String data_completa = dateFormat.format(data_atual);

        String hora_atual = dateFormat_hora.format(data_atual);

        Log.i("data_completa", data_completa);
        Log.i("data_atual", data_atual.toString());
        Log.i("hora_atual", hora_atual); // Esse é o que você quer

        return data_completa;
    }
}
