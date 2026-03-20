package biblioteca;

import java.time.LocalDate;

public class Libro extends ItemBiblioteca {
    protected String prestadoA;
    protected LocalDate fechaDevolucion;

    public Libro(String titulo) {
        super(titulo);
    }

    public void prestarA(String dni, LocalDate fechaDevolucion) {
        this.prestadoA = dni;
        this.fechaDevolucion = fechaDevolucion;
    }

    public void devolver() {
        this.prestadoA = null;
        this.fechaDevolucion = null;
    }

    public boolean estaPrestado() {
        return prestadoA != null;
    }
}