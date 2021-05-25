package com.anabibelforscher.recyclerview.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.LinearLayout;

import com.anabibelforscher.recyclerview.R;
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

    }

    public void criarFilmes (){
        Filme filme = new Filme("Belle","Drama Histórico","2013");
        this.mListaFilme.add(filme);

        filme = new Filme("Pride and Prejudice","Romance","2005");
        this.mListaFilme.add(filme);

        filme = new Filme("Rainha de Katwe","Drama","2017");
        this.mListaFilme.add(filme);

        filme = new Filme("Kong: A Ilha da Caveira","Ação","2017");
        this.mListaFilme.add(filme);

        filme = new Filme("Godzilla vs. Kong","Ação","2021");
        this.mListaFilme.add(filme);

        filme = new Filme("A Bailarina","Animação","2017");
        this.mListaFilme.add(filme);

        filme = new Filme("Meu Amigo, o Dragão","Drama","2016");
        this.mListaFilme.add(filme);

        filme = new Filme("Como Treinar o Seu Dragão","Animação","2010");
        this.mListaFilme.add(filme);

        filme = new Filme("Como Treinar o Seu Dragão 2","Animação","2014");
        this.mListaFilme.add(filme);

        filme = new Filme("Como Treinar o Seu Dragão 3","Animação","2019");
        this.mListaFilme.add(filme);

    }
}