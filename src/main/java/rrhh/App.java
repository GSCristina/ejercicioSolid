package rrhh;

public class App {

    public static void main(String[] args) {

        RepositorioEmpleados repo = new RepositorioEmpleadosEnMemoria();
        GeneradorPassword gen = new GeneradorPasswordSimple();

        AltaEmpleadoService s = new AltaEmpleadoService(repo, gen);

        s.alta("11111111A", "Lucía");
        s.alta("22222222B", "Álvaro");
    }
}