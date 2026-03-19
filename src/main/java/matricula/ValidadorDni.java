package matricula;

public class ValidadorDni {
    public static void validar(String dni) {
        if (dni == null || dni.isBlank() || dni.length() < 7) {
            throw new IllegalArgumentException("DNI inválido");
        }
    }
}
