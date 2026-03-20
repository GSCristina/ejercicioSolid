package biblioteca;

import java.time.LocalDate;

public class LibroReferencia extends ItemBiblioteca {

    public LibroReferencia(String titulo) {
        super(titulo);
    }

    public void consultarEnSala() {
        System.out.println("Consultando en sala: " + getTitulo());
    }
}