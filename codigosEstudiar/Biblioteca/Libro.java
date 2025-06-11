package codigosEstudiar.Biblioteca;

public class Libro {

    private static String[] librosDisponibles = { "1984", "Rayuela", "Drácula", "Ulises", "Siddhartha",
            "Frankenstein", "Crimen", "Cumbres", "Demian", "It",
            "Carrie", "Insomnia", "Misery", "Fuego", "Solaris",
            "Persépolis", "Infierno", "Hamlet", "Macbeth", "Coraline"
    };
    private String titulo;

    public Libro(String titulo) {
        this.titulo = titulo;
    }

    public static void verLibrosDisponibles() {
        System.out.println("==========================");
        System.out.println("Libros disponibles:");
        int contador = 1;
        for (String marca : librosDisponibles) {
            System.out.println(contador++ + ". " + marca);
        }
        System.out.println("==========================");

    }

    public static void buscarLibroPorTitulo(String libroEscogido) {
        boolean encontrado = false;
        for (String libro : librosDisponibles) {
            if (libro.equalsIgnoreCase(libroEscogido)) {
                System.out.println("Libro encontrado: " + libro);
                encontrado = true;
            }
        }
        if (!encontrado) {
            System.out.println("El libro '" + libroEscogido + "' no está disponible en la biblioteca.");
        }
    }

    public static Libro obtenerLibro(String titulo) {
        for (String libro : librosDisponibles) {
            if (libro.equalsIgnoreCase(titulo)) {
                return new Libro(titulo);
            }
        }
        return null;
    }

    public char[] getTitulo() {
        return titulo.toCharArray();
    }

}
