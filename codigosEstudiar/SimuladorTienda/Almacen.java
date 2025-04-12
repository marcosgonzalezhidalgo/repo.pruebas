package codigosEstudiar.SimuladorTienda;

public class Almacen {
    private Producto[] inventario;
    private int cantidadInventario;
    private static final int MAX_CAPACIDAD = 20;

    public Almacen() {
        inventario = new Producto[MAX_CAPACIDAD];
        cantidadInventario = 0;
    }
    
    public void añadirAlInventario(Producto producto) {
        if (cantidadInventario < inventario.length) {
            inventario[cantidadInventario] = producto;
            cantidadInventario++;
            System.out.println("El prodducto " + producto.getNombre() + " ha sido añadido al inventario.");
        } else {
            System.out.println("El inventario está lleno. No se pueden añadir más productos.");
        }
    }

    public void mostrarInventario() {
        if (cantidadInventario == 0) {
            System.out.println("El inventario está vacío.");
        } else {
            for (int i = 0; i < cantidadInventario; i++) {
                System.out.println((i + 1) + "." + inventario[i]);
            }
        }
    }
}
