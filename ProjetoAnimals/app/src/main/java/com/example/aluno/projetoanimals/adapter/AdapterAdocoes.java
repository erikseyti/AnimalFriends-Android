package com.example.aluno.projetoanimals.adapter;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.aluno.projetoanimals.R;
import com.example.aluno.projetoanimals.modelo.Adocao;
import com.example.aluno.projetoanimals.modelo.MausTratos;

import org.w3c.dom.Text;

import java.util.List;

/**
 * Created by Aluno on 17/06/2016.
 */
public class AdapterAdocoes extends BaseAdapter {
    private Activity activity;
    private List<Adocao> listaAdocao;

    //construtor que recebe a activity e a lista de Adoções
    public AdapterAdocoes(Activity activity, List<Adocao> listaAdocao)
    {
        this.activity =activity;
        this.listaAdocao =listaAdocao;
    }

    @Override
    public int getCount() {
        //quantidade de elementos
        return listaAdocao.size();
    }

    @Override
    public Object getItem(int position) {
        //retorna um item da lista pela sua posição
        return listaAdocao.get(position);
    }

    @Override
    public long getItemId(int position) {
        //retorna o id de um item da lista pela sua posição
        return listaAdocao.get(position).getId();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        //neste metodo vamos passar as informações que serão exibidas nas linhas
        View view = LayoutInflater.from(activity).inflate(R.layout.linha_list_view_adocao, parent,false);

        Adocao adocao = (Adocao) getItem(position);
        TextView textNome = (TextView) view.findViewById(R.id.textNome);
        TextView textDescricao =(TextView) view.findViewById(R.id.textDescricao);
        TextView textInformacoesA =(TextView) view.findViewById(R.id.textInformacaoContatoA);

        textNome.setText(adocao.getNome());
        textDescricao.setText(adocao.getDescricao());
        textInformacoesA.setText(adocao.getInformacaoContato());

        return view;
    }
}
