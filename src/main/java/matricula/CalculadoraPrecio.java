package matricula;

public class CalculadoraPrecio {
    public static double calcular(double precioBase, boolean bonificacion) {
        if (precioBase <= 0) throw new IllegalArgumentException("Precio inválido");
        double total = precioBase;
        if (bonificacion) total *= 0.85; // 15% descuento
        return total + 12.0;
    }
}
