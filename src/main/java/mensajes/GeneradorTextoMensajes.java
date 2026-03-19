package mensajes;

public class GeneradorTextoMensajes {

    public String generar(Mensaje msg) {
        String asuntoBase = "[" + msg.getCanal().toUpperCase() + "] ";
        return asuntoBase + msg.generarContenido();
    }
}