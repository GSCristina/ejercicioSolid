package mensajes;

public class MensajeAviso extends Mensaje {
    private final String destinatario;
    private final String fecha;

    public MensajeAviso(String canal, String destinatario, String titulo, String cuerpo, String fecha) {
        super(canal, titulo, cuerpo);
        this.destinatario = destinatario;
        this.fecha = fecha;
    }

    @Override
    public String generarContenido() {
        return "Aviso: " + getTitulo() + "\n" +
                "Hola " + destinatario + ",\n" +
                getCuerpo() + "\n" +
                "Fecha: " + fecha + "\n";
    }
}
