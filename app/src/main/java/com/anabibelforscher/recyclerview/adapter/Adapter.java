package com.anabibelforscher.recyclerview.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.anabibelforscher.recyclerview.R;
import com.anabibelforscher.recyclerview.model.Filme;

import java.util.List;

public class Adapter extends RecyclerView.Adapter<Adapter.MyViewHolder> {

    private List<Filme> listaFilmes;

    public Adapter(List<Filme> lista) {
        this.listaFilmes = lista;
    }

    @NonNull
    @Override
    //Não exibe itens, só cria visualização
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //Converter xml em visualização
        View itemLista = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.adapter_lista, parent, false);
        return new MyViewHolder(itemLista); //objeto criado
    }

    @Override
    //Exibição dos itens
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Filme filme = listaFilmes.get(position);
        holder.titulo.setText(filme.getTituloFilme());
        holder.ano.setText(filme.getAno());
        holder.genero.setText(filme.getGenero());
    }

    @Override
    //Quantidade de itens que serão exibidos
    public int getItemCount() {
        return listaFilmes.size();
    }

    //Guarda os dados antes de serem exibidos na tela
    public class MyViewHolder extends RecyclerView.ViewHolder{

        TextView titulo;
        TextView ano;
        TextView genero;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            titulo = itemView.findViewById(R.id.textTitulo);
            ano = itemView.findViewById(R.id.textAno);
            genero = itemView.findViewById(R.id.textGenero);
        }
    }

}
