package devandroid.joao.applistacurso.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.List;

import devandroid.joao.applistacurso.R;
import devandroid.joao.applistacurso.controller.CursoController;
import devandroid.joao.applistacurso.controller.PessoaControler;
import devandroid.joao.applistacurso.model.Curso;
import devandroid.joao.applistacurso.model.Pessoa;

public class MainActivity extends AppCompatActivity {
    Pessoa pessoa;
    PessoaControler controler;

    public static final String NOME_PREFERENCES = "pref_listaVip";

    CursoController cursoController;
    List<String> nomesDosCursos;


    EditText editPrimeiroNome;
    EditText editSobrenome;
    EditText editNomeDoCursoDesejado;
    EditText editTelefoneDeContato;

    Button btnLimpar;
    Button btnSalvar;
    Button btnFinalizar;

    Spinner spinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //antes era setContentView(R.layout.activity_main); foi mudado para o adquirir as configurações feitas no spinner.
        setContentView(R.layout.activity_spinner);

        controler = new PessoaControler(MainActivity.this);
        pessoa = new Pessoa();

        cursoController = new CursoController();
        nomesDosCursos = cursoController.dadosPAraSpinner();
        //para mostrar os dados na tela, que foram adiciondos antes.
        controler.buscarDados(pessoa);


        // textos
        editPrimeiroNome = findViewById(R.id.editPrimeiroNome);
        editSobrenome = findViewById(R.id.editSobrenome);
        editNomeDoCursoDesejado = findViewById(R.id.editNomeDoCursoDesejado);
        editTelefoneDeContato = findViewById(R.id.editTelefoneDeContato);

        // apresentar na tela
        editPrimeiroNome.setText(pessoa.getPrimeiroNome());
        editSobrenome.setText(pessoa.getSobrenome());
        editNomeDoCursoDesejado.setText(pessoa.getCursoDesejado());
        editTelefoneDeContato.setText(pessoa.getTelefoneContato());

        //botões
        btnLimpar = findViewById(R.id.btnLimpar);
        btnSalvar = findViewById(R.id.btnSalvar);
        btnFinalizar = findViewById(R.id.btnFinalizar);

        // spinner
        spinner = findViewById(R.id.spinner);

        //adapter string pq vai retornar os nomes. = ArrayAdapter<String> adapter = new ArrayAdapter<>
        //layout é esse android.R.layout.simple_list_item_1
        //injetar o daparter para o spinner e a lista sera gerada
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,
                cursoController.dadosPAraSpinner());
        adapter.setDropDownViewResource(android.R.layout.simple_list_item_1);
        spinner.setAdapter(adapter);
        //para fazer a tela rolar fez esse ScrollView
        //para colocar os botoes um ao lado do outro faz um linea layout só neles


        // fazendo pegar o clique e as funções
        btnLimpar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //limpando os dados
                editPrimeiroNome.setText("");
                editSobrenome.setText("");
                editNomeDoCursoDesejado.setText("");
                editTelefoneDeContato.setText("");
                controler.limpar();
            }
        });
        btnSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //salvando
                pessoa.setPrimeiroNome(editPrimeiroNome.getText().toString());
                pessoa.setSobrenome(editSobrenome.getText().toString());
                pessoa.setCursoDesejado(editNomeDoCursoDesejado.getText().toString());
                pessoa.setTelefoneContato(editTelefoneDeContato.getText().toString());

                //avisando
                Toast.makeText(MainActivity.this, "Salvo!"+pessoa.toString(), Toast.LENGTH_LONG).show();
                controler.salvar(pessoa);
            }
        });
        btnFinalizar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //mostrando msg ao finalizar
                Toast.makeText(MainActivity.this, "Programa Encerrado, Volte Sempre!", Toast.LENGTH_LONG).show();
                //finalizando
                finish();
            }
        });
        Log.i("POO android", "Objeto pessoa: "+pessoa.toString());
    }
}