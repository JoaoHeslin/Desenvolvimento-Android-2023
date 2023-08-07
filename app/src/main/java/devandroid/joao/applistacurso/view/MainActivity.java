package devandroid.joao.applistacurso.view;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;

import devandroid.joao.applistacurso.R;
import devandroid.joao.applistacurso.model.Pessoa;

public class MainActivity extends AppCompatActivity {
    Pessoa pessoa;
    Pessoa pessoa1;


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

        pessoa = new Pessoa();
        pessoa.setPrimeiroNome("João");
        pessoa.setSobrenome("Heslin");
        pessoa.setCursoDesejado("Dev Android");
        pessoa.setTelefoneContato("111.222");

        editPrimeiroNome = findViewById(R.id.editPrimeiroNome);
        editSobrenome = findViewById(R.id.editSobrenome);
        editNomeDoCursoDesejado = findViewById(R.id.editNomeDoCursoDesejado);
        editTelefoneDeContato = findViewById(R.id.editTelefoneDeContato);


        btnLimpar = findViewById(R.id.btnLimpar);
        btnSalvar = findViewById(R.id.btnSalvar);
        btnFinalizar = findViewById(R.id.btnFinalizar);


        editPrimeiroNome.setText(pessoa.getPrimeiroNome());
        editSobrenome.setText(pessoa.getSobrenome());
        editNomeDoCursoDesejado.setText(pessoa.getCursoDesejado());
        editTelefoneDeContato.setText(pessoa.getTelefoneContato());

    }
}