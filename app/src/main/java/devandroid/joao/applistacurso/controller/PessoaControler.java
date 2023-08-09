package devandroid.joao.applistacurso.controller;

import android.util.Log;

import devandroid.joao.applistacurso.model.Pessoa;

public class PessoaControler {
    public void salvar(Pessoa pessoa){
        Log.d("MVC_Controler", "salvo: "+pessoa.toString());
    }
}
