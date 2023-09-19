package devandroid.joao.applistacurso.model;

public class Curso {
    private String cursoDesejado;
    public Curso(){}
    public Curso(String cursoDesejado){
        this.cursoDesejado = cursoDesejado;
    }

    public String getCursoDesejado() {
        return this.cursoDesejado;
    }

    public void setCursoDesejado(String cursoDesejado) {
        this.cursoDesejado = cursoDesejado;
    }
}
