package matricula;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class MatriculaService {

    private final List<Matricula> matriculas = new ArrayList<>();

    public Matricula crearMatricula(String dni, String curso, double precioBase, boolean bonificacion) {

        ValidadorDni.validar(dni);

        double precioFinal = CalculadoraPrecio.calcular(precioBase, bonificacion);

        Matricula m = new Matricula(dni, curso, LocalDate.now(), precioFinal);
        matriculas.add(m);

        NotificadorMatricula.notificar(m);

        return m;
    }

    public String exportarResumen() {
        return GeneradorInformes.exportarResumen(matriculas);
    }
}