package codigosEstudiar.SimuladorTienda;

public class Cliente {
    private String nombre;
    private Carrito carrito;

    public static final int MAX_CLIENTES = 20;
    private static final String[] CLIENTES = {
            "Lucía", "Mateo", "Sofía", "Julián", "Valentina", "Diego", "Camila", "Andrés", "Isabella", "Sebastián",
            "Emilia", "Tomás", "Martina", "Gabriel", "Renata", "Samuel", "Antonella", "Benjamín", "Paula", "Nicolás"
    };

    public Cliente(String nombre) {
        this.nombre = nombre;
        this.carrito = new Carrito();
    }

    public String getNombre() {
        return nombre;
    }

    public Carrito getCarrito() {
        return carrito;
    }

    public void mostrarCarrito() {
        System.out.println("Carrito de " + nombre + ":");
        carrito.mostrarProductos();
    }

    public static String getNombreAleatorio() {
        int i = (int)(Math.random() * CLIENTES.length);
        return CLIENTES[i];
    }
}