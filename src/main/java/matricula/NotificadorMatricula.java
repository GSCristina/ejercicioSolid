package matricula;

public class NotificadorMatricula {
    public static void notificar(Matricula m) {
        System.out.println("[AVISO] Matriculado " + m.getDni() + " en " + m.getCurso() + " por " + m.getPrecioFinal() + "€");
    }
}
