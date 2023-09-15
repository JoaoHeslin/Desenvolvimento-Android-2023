package devandroid.joao.applistacurso.controller;

import android.content.SharedPreferences;
import android.util.Log;

import devandroid.joao.applistacurso.model.Pessoa;
import devandroid.joao.applistacurso.view.MainActivity;

public class PessoaControler {
    SharedPreferences preferences;
    public static final String NOME_PREFERENCES = "pref_listaVip";

    //arquivo pra receber os dados
    SharedPreferences.Editor listaVip;

    public PessoaControler(MainActivity mainActivity){
        //instanciando
        preferences = mainActivity.getSharedPreferences(NOME_PREFERENCES,0);
        //instanciando arquivo pra receber os dados
        listaVip = preferences.edit();
    }
    public void criarSharedPreferebces(){
    }
    public void salvar(Pessoa pessoa){
        Log.d("MVC_Controler", "salvo: "+pessoa.toString());

        //salvando os dados com o sharedPreferences
        listaVip.putString("primeiroNome",pessoa.getPrimeiroNome());
        listaVip.putString("sobreNome",pessoa.getSobrenome());
        listaVip.putString("cursoDesejado",pessoa.getCursoDesejado());
        listaVip.putString("telefoneContato",pessoa.getTelefoneContato());
        listaVip.apply();
    }
    public void buscarDados(){

    }
    public void limpar(){

    }
}
