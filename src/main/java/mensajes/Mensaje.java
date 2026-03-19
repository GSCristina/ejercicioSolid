package mensajes;

public abstract class Mensaje {
    private final String canal;
    private final String titulo;
    private final String cuerpo;

    public Mensaje(String canal, String titulo, String cuerpo) {
        this.canal = canal;
        this.titulo = titulo;
        this.cuerpo = cuerpo;
    }

    public String getCanal() { return canal; }
    public String getTitulo() { return titulo; }
    public String getCuerpo() { return cuerpo; }


    public abstract String generarContenido();
}