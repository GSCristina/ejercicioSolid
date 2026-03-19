package mensajes;

public class MensajeFelicitacion extends Mensaje {
    private final String destinatario;

    public MensajeFelicitacion(String canal, String destinatario, String titulo, String cuerpo) {
        super(canal, titulo, cuerpo);
        this.destinatario = destinatario;
    }

    @Override
    public String generarContenido() {
        return "¡Enhorabuena! " + getTitulo() + "\n" +
                destinatario + ", " + getCuerpo() + "\n";
    }
}
