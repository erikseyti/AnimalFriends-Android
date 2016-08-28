package com.example.aluno.projetoanimals;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Environment;
import android.os.StrictMode;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.aluno.projetoanimals.modelo.Adocao;

import java.io.File;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;


public class FormularioAdocao extends AppCompatActivity {
    Adocao adocao = new Adocao();
    public static final int MEDIA_TYPE_VIDEO = 2;
    private Uri fileUri;
    private static final int CAPTURE_IMAGE_ACTIVITY_REQUEST_CODE = 100;
    public static final int MEDIA_TYPE_IMAGE = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formulario_adocao);

        // é preciso pegar o id da denuncia que foi passada pela activity da lista

        if(getIntent().hasExtra("idAdocao")) {
            Bundle bundle = getIntent().getExtras();
            Long id = bundle.getLong("idAdocao");
            adocao = (Adocao) Adocao.findById(Adocao.class, id);

            // Metodo para setar os dados
            setarDadosAdocao();
        }
    }
    // este metodo serve para preencher os dados do formulario com os dados salvos dentro do Banco de Dados do Android
    private void setarDadosAdocao()
    {
        EditText editNome = (EditText) findViewById(R.id.editNome);
        EditText editDesc = (EditText) findViewById(R.id.editDescricao);
        EditText editInform = (EditText) findViewById(R.id.editInformacoesContatoA);
        EditText editCPF =(EditText) findViewById(R.id.editCPFAnunciante);
        EditText editNomeAn =(EditText) findViewById(R.id.editNomeAnunciante);
        EditText editEspecie =(EditText) findViewById(R.id.editEspecie);
        EditText editSexo =(EditText) findViewById(R.id.editSexo);
        EditText editPorte = (EditText) findViewById(R.id.editPorte);
        EditText editPelagem = (EditText) findViewById(R.id.editPelagem);
        EditText editRaca = (EditText) findViewById(R.id.editRaca);
        EditText editCastrado = (EditText) findViewById(R.id.editCastrado);
        EditText editLinkVideo = (EditText) findViewById(R.id.editLinkVideos);
        EditText editCidade = (EditText) findViewById(R.id.editCidade);
        EditText editPeso = (EditText) findViewById(R.id.editPeso);
        EditText editIdade = (EditText) findViewById(R.id.editIdade);
        EditText editDataCadastro =(EditText) findViewById(R.id.editDataCadastro);

        editNome.setText(adocao.getNome());
        editDesc.setText(adocao.getDescricao());
        editInform.setText(adocao.getInformacaoContato());
        editCPF.setText(adocao.getCpfAnunciante());
        editNomeAn.setText(adocao.getNomeAnunciante());
        editEspecie.setText(adocao.getEspecie());
        editSexo.setText(adocao.getSexo());
        editPorte.setText(adocao.getPorte());
        editPelagem.setText(adocao.getPelagem());
        editRaca.setText(adocao.getRaca());
        editCastrado.setText(adocao.getCastrado());
        editLinkVideo.setText(adocao.getLinkVideo());
        editCidade.setText(adocao.getCidade());
        editPeso.setText(String.valueOf(adocao.getPeso()));
        editIdade.setText(String.valueOf(adocao.getIdade()));
        editDataCadastro.setText(adocao.getDataCadastro());

        // como ja existe uma adoção no banco, é necessario habilitar o botão de excluir
        //que neste momento esta desabilitado

        Button bt = (Button) findViewById(R.id.botaoExcluirAdocao);
        bt.setEnabled(true);
    }

    public void cadastrarAdocao(View view)
    {

        EditText editNome = (EditText) findViewById(R.id.editNome);
        EditText editDesc = (EditText) findViewById(R.id.editDescricao);
        EditText editInform = (EditText) findViewById(R.id.editInformacoesContatoA);
        EditText editCpfAnunciante =(EditText) findViewById(R.id.editCPFAnunciante);
        EditText editNomeAnun =(EditText) findViewById(R.id.editNomeAnunciante);
        EditText editEspeci = (EditText) findViewById(R.id.editEspecie);
        EditText editSexo = (EditText) findViewById(R.id.editSexo);
        EditText editPorte = (EditText) findViewById(R.id.editPorte);
        EditText editPelagem =(EditText) findViewById(R.id.editPelagem);
        EditText editRaca = (EditText) findViewById(R.id.editRaca);
        EditText editCastrad = (EditText) findViewById(R.id.editCastrado);
        EditText editLink =(EditText) findViewById(R.id.editLinkVideos);
        EditText editCidade =(EditText) findViewById(R.id.editCidade);
        EditText editPeso =(EditText) findViewById(R.id.editPeso);
        EditText editIdade=( EditText) findViewById(R.id.editIdade);
        EditText editDataCadastro =(EditText) findViewById(R.id.editDataCadastro);


        String nomeAnunc = editNomeAnun.getText().toString();
        String informacaoContato = editInform.getText().toString();
        String descricaoAnimal = editDesc.getText().toString();

         if (TextUtils.isEmpty(nomeAnunc)) {
            editNomeAnun.setError("Informe o Nome do Anunciante");
            editNomeAnun.requestFocus();
            return;
        } else if (TextUtils.isEmpty(informacaoContato)) {
            editInform.setError("Informe as Informações de Contato");
            editInform.requestFocus();
            return;
        } else if (TextUtils.isEmpty(descricaoAnimal)) {
            editDesc.setError("Informe a Descrição do Animal");
            editDesc.requestFocus();
            return;
        }
        else {


             adocao.setNome(editNome.getText().toString());
             adocao.setDescricao(editDesc.getText().toString());
             adocao.setInformacaoContato(editInform.getText().toString());
             adocao.setCpfAnunciante(editCpfAnunciante.getText().toString());
             adocao.setNomeAnunciante(editNomeAnun.getText().toString());
             adocao.setEspecie(editEspeci.getText().toString());
             adocao.setSexo(editSexo.getText().toString());
             adocao.setPorte(editPorte.getText().toString());
             adocao.setPelagem(editPelagem.getText().toString());
             adocao.setRaca(editRaca.getText().toString());
             adocao.setCastrado(editCastrad.getText().toString());
             adocao.setLinkVideo(editLink.getText().toString());
             adocao.setCidade(editCidade.getText().toString());
             adocao.setIdade(Integer.parseInt(editIdade.getText().toString()));
             adocao.setPeso(Double.parseDouble(editPeso.getText().toString()));
             adocao.setDataCadastro(editDataCadastro.getText().toString());

             // Criada para Passar os parametros da classe Adocao para o Web Service
           //  passarDadosWebService(adocao.getNome(), adocao.getDescricao(), adocao.getInformacaoContato(), adocao.getCpfAnunciante(),
             //        adocao.getNomeAnunciante(), adocao.getEspecie(), adocao.getSexo(), adocao.getPorte(), adocao.getRaca(), adocao.getCastrado(),
               //      adocao.getLinkVideo(), adocao.getCidade(), adocao.getIdade(), adocao.getPeso(), adocao.getPelagem(), adocao.getDataCadastro());
             //inserir o cadastro da adoção no banco

             adocao.save();

             //finaliza a activity de formulario de adoções e volta para a lista de adoções
             finish();
         }
    }

    private void passarDadosWebService(String nome, String descricao, String informacao,String cpf, String nomeAnunciante,String especie,
     String sexo,String porte,String raca, String castrado, String linkVideo, String cidade, Integer idade, Double peso,String pelagem,
                                       String dataCadastro){
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);

        String myurl = "http://172.17.241.67:8081/ServicoWeb/resource/WebService/addAdocao";
        String POST_PARAMS = "nome="+nome+"&descricao="+descricao+"&informacao="+informacao+"&cpf="+cpf
                +"&nomeAnunciante="+nomeAnunciante+"&especie="+ especie +"&sexo="+sexo+"&porte="+porte +"&raca="+raca+"&castrado="+
                castrado+"&linkVideo="+linkVideo+"&cidade="+cidade+"&idade="+idade+"&peso="+peso+"&pelagem="+pelagem+"&dataCadastro="+dataCadastro;
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

    public void excluirAdocao(View view)
    {
        //deletar a adocao
        adocao.delete();
        //fechar a activity
        finish();
    }

    public void tirarFoto(View view)
    {
        Intent it = new Intent("android.media.action.IMAGE_CAPTURE");
        startActivityForResult(it, 0);
        startActivityForResult(it, 0);
    }

    public void abrirCamera(View view) {
        // create Intent to take a picture and return control to the calling application
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);

        fileUri = getOutputMediaFileUri(MEDIA_TYPE_IMAGE); // create a file to save the image
        intent.putExtra(MediaStore.EXTRA_OUTPUT, fileUri); // set the image file name

        // start the image capture Intent
        startActivityForResult(intent, CAPTURE_IMAGE_ACTIVITY_REQUEST_CODE);

    }

    private static Uri getOutputMediaFileUri(int type) {
        return Uri.fromFile(getOutputMediaFile(type));
    }


    @Override
    protected void onActivityResult(int requestCode,int resultCode, Intent data)
    {
        if(data != null)
        {
            Bundle bundle= data.getExtras();
            if(bundle!=null)
            {
                Bitmap img= (Bitmap) bundle.get("data");

                ImageView iv = (ImageView) findViewById(R.id.imageViewAdocao);
                iv.setImageBitmap(img);



            }
        }
    }


    private static File getOutputMediaFile(int type) {
        // To be safe, you should check that the SDCard is mounted
        // using Environment.getExternalStorageState() before doing this.

        File mediaStorageDir = new File(Environment.getExternalStoragePublicDirectory(
                Environment.DIRECTORY_PICTURES), "MyCameraApp");
        // This location works best if you want the created images to be shared
        // between applications and persist after your app has been uninstalled.

        // Create the storage directory if it does not exist
        if (!mediaStorageDir.exists()) {
            if (!mediaStorageDir.mkdirs()) {
                Log.d("MyCameraApp", "failed to create directory");
                return null;
            }
        }
        // Create a media file name
        String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        File mediaFile;
        if (type == MEDIA_TYPE_IMAGE) {
            mediaFile = new File(mediaStorageDir.getPath() + File.separator +
                    "IMG_" + timeStamp + ".jpg");
        }
        else {
            return null;
        }

        return mediaFile;
    }


}




