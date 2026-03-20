package biblioteca;

public class BibliotecaApp {

    public static void main(String[] args) {
        PrestamoService service = new PrestamoService();

        Libro dune = new Libro("Dune");
        LibroReferencia diccionario = new LibroReferencia("Diccionario RAE");


        service.prestar(dune, "12345678A");
        diccionario.consultarEnSala(); // No usamos el servicio de préstamos para esto

        System.out.println();

        System.out.println("Devuelto (" + dune.getTitulo() + "): " + service.devolver(dune));

    }
}