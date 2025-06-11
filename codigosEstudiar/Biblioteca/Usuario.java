package codigosEstudiar.Biblioteca;

abstract class Usuario {

    protected String nombre;
    protected String apellido;
    protected String dni;

    protected Libro[] librosPrestados = new Libro[100]; 
    protected int totalPrestados = 0;

    public Usuario(String nombre, String apellido, String dni) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
    }

    public abstract String toString();

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public String getDni() {
        return dni;

    }

    public void tomarPrestado(Libro libro) {
        librosPrestados[totalPrestados] = libro;
        totalPrestados++;
    }

    public void imprimirLibrosPrestados() {
        if (totalPrestados == 0) {
            System.out.println("No tienes libros prestados.");
        } else {
            System.out.println("Libros prestados:");
            for (int i = 0; i < totalPrestados; i++) {
                char[] titulo = librosPrestados[i].getTitulo();
                System.out.println("- " + new String(titulo));
            }
        }
    }
}
