package mensajes;

public class MensajeIncidencia extends Mensaje {
    private final String alumno;
    private final String tutoria;
    private final String gravedad;

    public MensajeIncidencia(String canal, String titulo, String cuerpo, String alumno, String tutoria, String gravedad) {
        super(canal, titulo, cuerpo);
        this.alumno = alumno;
        this.tutoria = tutoria;
        this.gravedad = gravedad;
    }

    @Override
    public String generarContenido() {
        return "Incidencia (" + gravedad + "): " + getTitulo() + "\n" +
                "Alumno/a: " + alumno + "\n" +
                "Tutoría: " + tutoria + "\n" +
                "Detalle: " + getCuerpo() + "\n";
    }
}
