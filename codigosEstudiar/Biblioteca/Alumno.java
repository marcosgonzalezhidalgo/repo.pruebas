package codigosEstudiar.Biblioteca;

public class Alumno extends Usuario {

    private String curso;

    public Alumno(String nombre, String apellido, String dni, String curso) {
        super(nombre, apellido, dni);
        this.curso = curso;
    }

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    @Override
    public String toString() {
        return "Alumno{" +
                "nombre='" + getNombre() + '\'' +
                ", apellido='" + getApellido() + '\'' +
                ", dni='" + getDni() + '\'' +
                ", curso='" + curso + '\'' +
                '}';
    }

    @Override
    public void tomarPrestado(Libro libro) {
        if (totalPrestados >= 5) {
            System.out.println("Has alcanzado el límite de 5 libros prestados.");
        } else {
            librosPrestados[totalPrestados] = libro;
            totalPrestados++;
            System.out.println("Libro prestado correctamente.");
        }
    }
}
