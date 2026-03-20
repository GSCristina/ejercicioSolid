package biblioteca;

import java.time.LocalDate;

public abstract class ItemBiblioteca {
    protected final String titulo;

    public ItemBiblioteca(String titulo) {
        this.titulo = titulo;
    }

    public String getTitulo() {
        return titulo;
    }
}
