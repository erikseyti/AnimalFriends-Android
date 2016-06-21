package com.example.aluno.projetoanimals.lista;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.aluno.projetoanimals.FormularioAdocao;
import com.example.aluno.projetoanimals.R;
import com.example.aluno.projetoanimals.adapter.AdapterAdocoes;
import com.example.aluno.projetoanimals.modelo.Adocao;

import java.util.List;

public class ListaAdocao extends AppCompatActivity implements AdapterView.OnItemClickListener {

    private AdapterAdocoes adapterAdocoes;
    private ListView listAdocao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_adocao);

        listAdocao =(ListView) findViewById(R.id.listAdocao);
        //A listView sera preenchida assim que a Activity for criada
        preencherListView();

        listAdocao.setOnItemClickListener(this);
    }

    @Override
    protected void onPostResume()
    {
        super.onPostResume();
        preencherListView();
    }


    private  void preencherListView()
    {
        adapterAdocoes = new AdapterAdocoes(this, getListaAdocao());
        listAdocao.setAdapter(adapterAdocoes);
    }

    //vamos criar um metodo para retornar os produtos cadastrados no banco
    private List<Adocao> getListaAdocao()
    {
        List<Adocao> la = Adocao.listAll(Adocao.class);
        return la;
    }


    public void novaAdocao(View view)
    {
        Intent it = new Intent(this, FormularioAdocao.class);
        startActivity(it);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        //iremos recuperar o id da adoção ao qual o usuario clicar
        Long idAD = adapterAdocoes.getItemId(position);

        // é necessario passar o id para a activity do formulario, para a edição da adoção

        Bundle bundle =new Bundle();
        bundle.putLong("idAdocao", idAD);

        // chamar a activity do formulario
        Intent it = new Intent(this,FormularioAdocao.class);
        it.putExtras(bundle);
        startActivity(it);

    }
}
