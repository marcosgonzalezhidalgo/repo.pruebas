package codigosEstudiar.SimuladorFinanciero;

public class Cliente {
    private String nombre;
    private String apellido;
    private String dni;
    private String telefono;
    private String email;

    public Cliente(String nombre, String apellido, String dni, String telefono, String email) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = String.format("%04d - %04d", (int) (Math.random() * 9000) + 1000, (int) (Math.random() * 9000) + 1000);
        this.telefono = String.format("%03d %02d %02d %02d",
            (int) (Math.random() * 445) + 555, (int) (Math.random() * 90) + 10,
            (int) (Math.random() * 90) + 10,
            (int) (Math.random() * 90) + 10);
        this.email = (int) (Math.random() * (99999999 + 10000000)) + 10000000 + "@gmail.com";
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

    public String getTelefono() {
        return telefono;
    }

    public String getEmail() {
        return email;
    }

    public String toString() {
        return "Nombre: " + nombre + "\n" +
                "Apellido: " + apellido + "\n" +
                "DNI: " + dni + "\n" +
                "Teléfono: " + telefono + "\n" +
                "Email: " + email;
    }

    public int cantidadDineroUsuario() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'cantidadDineroUsuario'");
    }
}
