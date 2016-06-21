package com.example.aluno.projetoanimals;

import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.aluno.projetoanimals.modelo.MausTratos;

import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;


public class FormularioMausTratos extends AppCompatActivity {
    MausTratos mausTratos = new MausTratos();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formulario_maus_tratos);

        // é preciso pegar o id da denuncia que foi passada pela activity da lista

        if(getIntent().hasExtra("idMausTratos"))
        {
        Bundle bundle = getIntent().getExtras();
        Long id =bundle.getLong("idMausTratos");
        mausTratos=(MausTratos) MausTratos.findById(MausTratos.class,id);

        // Metodo para setar os dados
            setarDadosMausTratos();
        }


    }

    private void setarDadosMausTratos()
    {
        EditText editDescAnimal = (EditText) findViewById(R.id.editDescricaoAnimal);
        EditText editInformacoes = (EditText) findViewById(R.id.editInformacoesContatoMT);
        EditText editCidade =(EditText) findViewById(R.id.editCidade);
        EditText editLatitude = (EditText) findViewById(R.id.editLatitude);
        EditText editLongitude = (EditText) findViewById(R.id.editLongitude);

        editDescAnimal.setText(mausTratos.getDescricaoAnimal());
        editInformacoes.setText(mausTratos.getInformacoesContato());
        editCidade.setText(mausTratos.getCidade());
        editLatitude.setText(String.valueOf(mausTratos.getLatitude()));
        editLongitude.setText(String.valueOf(mausTratos.getLongitude()));

        // como ja existe uma Denuncia de Maus Tratos no banco, é necessario habilitar o botão de excluir
        //que neste momento esta desabilitado

        Button bt = (Button) findViewById(R.id.botaoExcluirMausTratos);
        bt.setEnabled(true);
    }

    public void cadastrarMausTratos(View view)
    {

        EditText editDescAnimal = (EditText) findViewById(R.id.editDescricaoAnimal);
        EditText editInformacoes = (EditText) findViewById(R.id.editInformacoesContatoMT);
        EditText editCidade =(EditText) findViewById(R.id.editCidade);
        EditText editLatitude =(EditText) findViewById(R.id.editLatitude);
        EditText editLongitude =(EditText) findViewById(R.id.editLongitude);

        mausTratos.setDescricaoAnimal(editDescAnimal.getText().toString());
        mausTratos.setInformacoesContato(editInformacoes.getText().toString());
        mausTratos.setCidade(editCidade.getText().toString());
        mausTratos.setLatitude(Double.parseDouble(editLatitude.getText().toString()));
        mausTratos.setLongitude(Double.parseDouble(editLongitude.getText().toString()));

        //inserir o cadastro de maus tratos no banco
        passarDadosWebService(mausTratos.getDescricaoAnimal(),mausTratos.getCidade(),mausTratos.getInformacoesContato(), mausTratos.getLatitude(),mausTratos.getLongitude());
        mausTratos.save();

        //finaliza a activity de formulario de maus tratos e volta para a lista de maus tratos
        finish();

    }
    private void passarDadosWebService(String descricao, String cidade, String informacao, Double latitude,Double longitude){
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);
        // mudar o numero da maquina local: 172.17.250.240, para o numero da maquina executada
        String myurl = "http://172.17.250.240:8080/ServicoWeb/resource/WebService/add";
        String POST_PARAMS = "Descrição ="+descricao+"Cidade ="+cidade+"Informação ="+informacao+"Latitude"+latitude+"Longitude"+longitude;
        try {
            URL url = new URL(myurl);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setReadTimeout(10000 /* milliseconds */);
            conn.setConnectTimeout(15000 /* milliseconds */);
            conn.setRequestMethod("POST");
            conn.setDoInput(true);

            OutputStream os = conn.getOutputStream();
            os.write(POST_PARAMS.getBytes());
            os.flush();
            os.close();

            conn.connect();
            int response = conn.getResponseCode();
            Log.i("MainActivity", "The response is: " + response);

        }catch (Exception e){
            e.printStackTrace();
        }
    }


    public void excluirMausTratos(View view)
    {
        //deletar a denuncia de maus tratos
        mausTratos.delete();
        // fechar a activity
        finish();
    }

}
