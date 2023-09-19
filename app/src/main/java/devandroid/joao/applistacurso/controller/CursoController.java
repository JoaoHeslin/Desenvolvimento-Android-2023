package devandroid.joao.applistacurso.controller;

import java.util.ArrayList;
import java.util.List;

import devandroid.joao.applistacurso.model.Curso;

public class CursoController {

    private List<Curso> listCursos;

    public List<Curso> getListaDeCursos(){
        listCursos = new ArrayList<>();

        listCursos.add(new Curso("Java"));
        listCursos.add(new Curso("C#"));
        listCursos.add(new Curso("HTML"));
        listCursos.add(new Curso("Android"));
        listCursos.add(new Curso("Python"));

        return listCursos;
    }

    // enviando para o spinner
    public ArrayList<String> dadosPAraSpinner(){

        ArrayList<String> dados = new ArrayList<>();
        for (int i = 0; i < getListaDeCursos().size(); i++) {

            Curso objeto = getListaDeCursos().get(i);
            dados.add(objeto.getCursoDesejado());
        }
        return dados;
    }
}
