package codigosEstudiar.Biblioteca;

import java.util.Scanner;

public class Blibioteca {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Usuario usuario = preguntarPersona(scanner);

        System.out.println("==========================");
        System.out.println("Bienvenido a la Biblioteca");
        System.out.println("Seleccione una opción:");

        iniciarBiblioteca(scanner, usuario);
    }

    public static void impirimirOpciones() {
        System.out.println("==========================");
        System.out.println("1. Ver libros disponibles");
        System.out.println("2. Buscar libro por título");
        System.out.println("3. Tomar un libro prestado");
        System.out.println("4. Ver libros prestados");
        System.out.println("5. Salir");
        System.out.println("==========================");
    }

    public static void iniciarBiblioteca(Scanner scanner, Usuario usuario) {
        boolean eligiendo = true;
        int opcion = 0;

        while (eligiendo) {
            impirimirOpciones();
            opcion = scanner.nextInt();

            if (opcion == 1) {
                Libro.verLibrosDisponibles();
            } else if (opcion == 2) {
                System.out.println("Por favor, ingrese el título del libro que desea buscar:");
                String libroEscogido = scanner.next();
                Libro.buscarLibroPorTitulo(libroEscogido);
            } else if (opcion == 3) {
                System.out.println("Ingrese el título del libro que desea tomar prestado:");
                String titulo = scanner.next();
                Libro libro = Libro.obtenerLibro(titulo);
                if (libro != null) {
                    usuario.tomarPrestado(libro);
                } else {
                    System.out.println("Libro no encontrado.");
                }
            } else if (opcion == 4) {
                System.out.println("Libros prestados por " + usuario.getNombre() + ":");
                usuario.imprimirLibrosPrestados();

            } else if (opcion == 5) {
                System.out.println("Gracias por visitar la Biblioteca. ¡Hasta luego!");
                eligiendo = false;
            } else {
                System.out.println("Opción no válida. Por favor, intente de nuevo.");

            }
        }

    }

    public static Usuario preguntarPersona(Scanner scanner) {
        System.out.println("¿Eres alumno o profesor?");
        System.out.println("1. Alumno");
        System.out.println("2. Profesor");
        int opcionPersona = scanner.nextInt();
        if (opcionPersona == 1) {
            System.out.println("Has seleccionado Alumno.");
            System.out.println("Por favor, ingrese su nombre:");
            String nombre = scanner.next();
            System.out.println("Por favor, ingrese su apellido:");
            String apellido = scanner.next();
            System.out.println("Su DNI es 12345678A.");
            String dni = "12345678A";
            System.out.println("Su curso actual es 1º ESO.");
            String curso = "1º ESO";
            return new Alumno(nombre, apellido, dni, curso);

        } else if (opcionPersona == 2) {
            System.out.println("Has seleccionado Profesor.");
            System.out.println("Por favor, ingrese su nombre:");
            String nombre = scanner.next();
            System.out.println("Por favor, ingrese su apellido:");
            String apellido = scanner.next();
            System.out.println("Su DNI es 87654321B.");
            String dni = "87654321B";
            return new Profesor(nombre, apellido, dni);
        } else {
            System.out.println("Opción no válida. Por favor, intente de nuevo.");
            return preguntarPersona(scanner);
        }
    }

}