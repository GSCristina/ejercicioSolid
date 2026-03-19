package matricula;

import java.util.List;

public class GeneradorInformes {
    public static String exportarResumen(List<Matricula> matriculas) {
        StringBuilder resultado = new StringBuilder("RESUMEN MATRÍCULAS\n");
        for (Matricula m : matriculas) {
            resultado.append(m.getDni()).append(" | ")
                    .append(m.getCurso()).append(" | ")
                    .append(m.getFecha()).append(" | ")
                    .append(m.getPrecioFinal()).append("\n");
        }
        return resultado.toString();
    }
}