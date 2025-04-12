package codigosEstudiar.SimuladorTienda;

public class Cliente {
    private String nombre;
    private Carrito carrito;

    public Cliente(String nombre){
        this.nombre = nombre;
        this.carrito = new Carrito();
    }

    public String getNombre(){
        return nombre;
    }

    public Carrito getCarrito(){
        return carrito;
    }

    public void mostrarCarrito(){
        System.out.println("Carrito de " + nombre + ":");
        carrito.mostrarProductos();
    }
}
