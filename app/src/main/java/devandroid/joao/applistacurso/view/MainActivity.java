package devandroid.joao.applistacurso.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import devandroid.joao.applistacurso.R;
import devandroid.joao.applistacurso.controller.PessoaControler;
import devandroid.joao.applistacurso.model.Pessoa;

public class MainActivity extends AppCompatActivity {
    Pessoa pessoa;
    PessoaControler controler;
    SharedPreferences preferences;
    public static final String NOME_PREFERENCES = "pref_listaVip";


    EditText editPrimeiroNome;
    EditText editSobrenome;
    EditText editNomeDoCursoDesejado;
    EditText editTelefoneDeContato;

    Button btnLimpar;
    Button btnSalvar;
    Button btnFinalizar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        controler = new PessoaControler();
        //instanciando
        preferences = getSharedPreferences(NOME_PREFERENCES,0);
        //arquivo pra receber os dados
        SharedPreferences.Editor listaVip = preferences.edit();

        pessoa = new Pessoa();
        pessoa.setPrimeiroNome("João");
        pessoa.setSobrenome("Heslin");
        pessoa.setCursoDesejado("Dev Android");
        pessoa.setTelefoneContato("111.222");

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

        // fazendo pegar o clique e as funções
        btnLimpar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //limpando os dados
                editPrimeiroNome.setText("");
                editSobrenome.setText("");
                editNomeDoCursoDesejado.setText("");
                editTelefoneDeContato.setText("");
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

                //salvando os dados com o sharedPreferences
                listaVip.putString("primeiroNome",pessoa.getPrimeiroNome());
                listaVip.putString("sobreNome",pessoa.getSobrenome());
                listaVip.putString("cursoDesejado",pessoa.getCursoDesejado());
                listaVip.putString("telefoneContato",pessoa.getTelefoneContato());
                listaVip.apply();

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