package com.example.aluno.projetoanimals.adapter;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.aluno.projetoanimals.R;
import com.example.aluno.projetoanimals.modelo.MausTratos;

import java.util.List;

/**
 * Created by Aluno on 17/06/2016.
 */
public class AdapterMausTratos extends BaseAdapter {
    private Activity activity;
    private List<MausTratos> listaMausTratos;

    //construtor que recebe a activity e a lista de Maus Tratos
    public AdapterMausTratos(Activity activity,List<MausTratos> listaMausTratos)
    {
        this.activity =activity;
        this.listaMausTratos = listaMausTratos;
    }

    @Override
    public int getCount() {
        //quantidade de elementos
        return listaMausTratos.size();
    }

    @Override
    public Object getItem(int position) {
        //retorna a posição de um objeto na lista
        return listaMausTratos.get(position);
    }

    @Override
    public long getItemId(int position) {
        //retorna o id de um elemento por meio da sua posição
        return listaMausTratos.get(position).getId();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        //neste metodo vamos passar as informações que serão exibidas nas linhas
        View view = LayoutInflater.from(activity).inflate(R.layout.linha_list_view_maus_tratos, parent,false);

        MausTratos mausTratos = (MausTratos) getItem(position);
        TextView textDescricaoAnimal = (TextView) view.findViewById(R.id.textDescricaoAnimal);
        TextView textInformacoesMT =(TextView) view.findViewById(R.id.textInformacaoContatoMT);
        TextView textCidade =(TextView) view.findViewById(R.id.textCidade);

        textDescricaoAnimal.setText(mausTratos.getDescricaoAnimal());
        textInformacoesMT.setText(mausTratos.getInformacoesContato());
        textCidade.setText(mausTratos.getCidade());

        return view;
    }
}
