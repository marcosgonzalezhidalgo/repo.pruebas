package codigosEstudiar.AplicacionVotaciones;

public class Votante {
    private String nombre;
    private String apellido;
    private String dni;
    private int edad;
    private String direccion;
    private int telefono;
    private String correoElectronico;

    public Votante(String nombre, String apellido, String dni, int edad, String direccion, int telefono, String correoElectronico) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
        this.edad = edad;
        this.direccion = direccion;
        this.telefono = telefono;
        this.correoElectronico = correoElectronico;
    }

    public String getNombre() {
        return nombre;
    }   

    public String getApellido() {
        return apellido;
    }   

    public String getDni() {
        return dni;
    }

    public int getEdad() {
        return edad;
    }

    public String getDireccion() {
        return direccion;
    }   

    public int getTelefono() {
        return telefono;
    }

    public String getCorreoElectronico() {
        return correoElectronico;
    }

    public String toStringVotante() {
        return "---- Votante ----\n" +
       "Nombre: " + nombre + "\n" +
       "Apellido: " + apellido + "\n" +
       "DNI: " + dni + "\n" +
       "Edad: " + edad + "\n" +
       "Dirección: " + direccion + "\n" +
       "Teléfono: " + telefono + "\n" +
       "Email: " + correoElectronico;
    }
}
