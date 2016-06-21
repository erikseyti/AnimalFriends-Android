package com.example.aluno.projetoanimals.lista;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.aluno.projetoanimals.FormularioMausTratos;
import com.example.aluno.projetoanimals.R;
import com.example.aluno.projetoanimals.adapter.AdapterAdocoes;
import com.example.aluno.projetoanimals.adapter.AdapterMausTratos;
import com.example.aluno.projetoanimals.modelo.MausTratos;

import java.util.List;

public class ListaMausTratos extends AppCompatActivity implements AdapterView.OnItemClickListener {

    private AdapterMausTratos adapterMausTratos;
    private ListView listMausTratos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_maus_tratos);

        listMausTratos = (ListView) findViewById(R.id.listMausTratos);
        //A listView sera preenchida assim que a Activity for criada
        preencherListView();

        listMausTratos.setOnItemClickListener(this);
    }

    @Override
    protected void onPostResume()
    {
        super.onPostResume();
        preencherListView();
    }

    private  void preencherListView()
    {
        adapterMausTratos = new AdapterMausTratos(this, getListaMausTratos());
        listMausTratos.setAdapter(adapterMausTratos);
    }

    //vamos criar um metodo para retornar os produtos cadastrados no banco
    private List<MausTratos> getListaMausTratos()
    {
        List<MausTratos> lmt = MausTratos.listAll(MausTratos.class);
        return lmt;
    }


    public void novaDenunciaMausTratos(View view)
    {
        Intent it = new Intent(this, FormularioMausTratos.class);
        startActivity(it);
    }


    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        //iremos recuperar o id da adoção ao qual o usuario clicar
        Long idMT = adapterMausTratos.getItemId(position);

        // é necessario passar o id para a activity do formulario, para a edição da adoção

        Bundle bundle =new Bundle();
        bundle.putLong("idMausTratos", idMT);

        // chamar a activity do formulario
        Intent it = new Intent(this,FormularioMausTratos.class);
        it.putExtras(bundle);
        startActivity(it);



    }
}
