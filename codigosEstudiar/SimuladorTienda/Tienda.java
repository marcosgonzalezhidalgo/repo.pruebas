package codigosEstudiar.SimuladorTienda;

public class Tienda {
    public static void main(String[] args) {
        Almacen almacen = new Almacen();

        Producto p1 = new Producto("Camiseta", 19.99);
        Producto p2 = new Producto("Pantalón", 39.99);
        Producto p3 = new Producto("Zapatos", 59.99);
        Producto p4 = new Producto("Gorra", 14.99);
        Producto p5 = new Producto("Chaqueta", 89.99);
        Producto p6 = new Producto("Bufanda", 29.99);
        Producto p7 = new Producto("Guantes", 9.99);

        almacen.añadirAlInventario(p1);
        almacen.añadirAlInventario(p2);
        almacen.añadirAlInventario(p3);
        almacen.añadirAlInventario(p4);
        almacen.añadirAlInventario(p5);
        almacen.añadirAlInventario(p6);
        almacen.añadirAlInventario(p7);

        almacen.mostrarInventario();

        Cliente cliente = new Cliente("Juan");
        cliente.getCarrito().añadirProductos(p1);
        cliente.getCarrito().añadirProductos(p2);
        cliente.getCarrito().añadirProductos(p3);

        cliente.mostrarCarrito();
        
    }
}
