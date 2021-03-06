package com.anabibelforscher.recyclerview.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.anabibelforscher.recyclerview.R;
import com.anabibelforscher.recyclerview.RecyclerItemClickListener;
import com.anabibelforscher.recyclerview.adapter.Adapter;
import com.anabibelforscher.recyclerview.model.Filme;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private List<Filme> mListaFilme = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mRecyclerView = findViewById(R.id.recyclerView);

        //Listagem de filmes
        this.criarFilmes();

        //Configurar com.anabibelforscher.recyclerview.adapter (Recebe os dados e formata no layout)
        Adapter adapter = new Adapter(mListaFilme);

        //Configurar RecyclerView
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        mRecyclerView.setLayoutManager(layoutManager);
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.addItemDecoration(new DividerItemDecoration(this, LinearLayout.VERTICAL));
        mRecyclerView.setAdapter(adapter);

        //Evento de click
        mRecyclerView.addOnItemTouchListener(
                new RecyclerItemClickListener(
                        getApplicationContext(),
                        mRecyclerView,
                        new RecyclerItemClickListener.OnItemClickListener() {
                            @Override
                            public void onItemClick(View view, int position) {
                                Filme filme = mListaFilme.get(position);
                                Toast.makeText(
                                        getApplicationContext(),
                                        "Item pressionado: " + filme.getTituloFilme(),
                                        Toast.LENGTH_SHORT
                                ).show();
                            }

                            @Override
                            public void onLongItemClick(View view, int position) {
                                Filme filme = mListaFilme.get(position);
                                Toast.makeText(
                                        getApplicationContext(),
                                        "G??nero: " + filme.getGenero(),
                                        Toast.LENGTH_SHORT
                                ).show();
                            }

                            @Override
                            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                            }
                        }
                )
        );

    }

    public void criarFilmes (){
        Filme filme = new Filme("Belle","Drama Hist??rico","2013");
        this.mListaFilme.add(filme);

        filme = new Filme("Pride and Prejudice","Romance","2005");
        this.mListaFilme.add(filme);

        filme = new Filme("Rainha de Katwe","Drama","2017");
        this.mListaFilme.add(filme);

        filme = new Filme("Kong: A Ilha da Caveira","A????o","2017");
        this.mListaFilme.add(filme);

        filme = new Filme("Godzilla vs. Kong","A????o","2021");
        this.mListaFilme.add(filme);

        filme = new Filme("A Bailarina","Anima????o","2017");
        this.mListaFilme.add(filme);

        filme = new Filme("Meu Amigo, o Drag??o","Drama","2016");
        this.mListaFilme.add(filme);

        filme = new Filme("Como Treinar o Seu Drag??o","Anima????o","2010");
        this.mListaFilme.add(filme);

        filme = new Filme("Como Treinar o Seu Drag??o 2","Anima????o","2014");
        this.mListaFilme.add(filme);

        filme = new Filme("Como Treinar o Seu Drag??o 3","Anima????o","2019");
        this.mListaFilme.add(filme);

    }
}