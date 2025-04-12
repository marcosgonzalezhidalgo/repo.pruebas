package codigosEstudiar.SimuladorTienda;

public class Carrito {
    private Producto[] productos;
    private int cantidadProductos;
    private static final int MAX_PRODUCTOS = 10;

    public Carrito() {
        productos = new Producto[MAX_PRODUCTOS];
        cantidadProductos = 0;
    }

    public void añadirProductos(Producto producto) {
        if (cantidadProductos < productos.length) {
            productos[cantidadProductos] = producto;
            cantidadProductos++;
            System.out.println("Producto añadido al carrito: " + producto);
        } else {
            System.out.println("El carrito está lleno. No se pueden añadir más productos.");
        }
    }

    public void mostrarProductos() {
        if (cantidadProductos == 0) {
            System.out.println("El carrito está vacío.");
        } else {
            for (int i = 0; i < cantidadProductos; i++) {
                System.out.println(productos[i]);
            }
            System.out.println("Total: " + calcularTotal() + "$");
        }
    }
    public double calcularTotal() {
        double total = 0;
        for (int i = 0; i < cantidadProductos; i++) {
            total += productos[i].getPrecio();
        }
        return total;
    }
}
