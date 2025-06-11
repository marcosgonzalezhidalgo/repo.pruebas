package codigosEstudiar.Biblioteca;

public class Profesor extends Usuario {

    public Profesor(String nombre, String apellido, String dni) {
        super(nombre, apellido, dni);
    }

    @Override
    public String toString() {
        return "Alumno{" +
                "nombre='" + getNombre() + '\'' +
                ", apellido='" + getApellido() + '\'' +
                ", dni='" + getDni() + '\'' +
                '}';
    }

    @Override
    public void tomarPrestado(Libro libro) {
        librosPrestados[totalPrestados] = libro;
        totalPrestados++;
        System.out.println("Libro prestado correctamente.");
    }

}
