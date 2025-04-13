package codigosEstudiar.SimuladorTienda;

public class Pedido {
    public static final int MAX_PEDIDO = 15;
    private Producto[] productos;
    public int cantidadPedido;
    private String[] nombre = {
            "1. Leche", "2. Pan", "3. Huevos", "4. Tomates", "5. Manzanas", "6. Plátanos", "7. Arroz", "8. Pasta",
            "9. Aceite", "10. Azúcar", "11. Harina", "12. Café", "13. Té", "14. Jugo", "15. Mantequilla", "16. Queso",
            "17. Yogur", "18. Sal", "19. Pimienta", "20. Ajo", "21. Cebolla", "22. Zanahorias", "23. Lechuga",
            "24. Pepinos", "25. Papas", "26. Pechugas de pollo", "27. Pescado", "28. Galletas", "29. Chocolate",
            "30. Cereales"
    };
    private double[] precio = {
            1.50, 0.80, 2.00, 1.20, 0.60, 0.50, 1.00, 1.50,
            2.50, 0.70, 1.80, 3.00, 2.20, 1.50, 2.00, 3.50,
            2.80, 0.90, 1.10, 0.40, 0.60, 0.80, 1.20,
            1.50, 2.00, 3.00, 4.00, 5.00, 6.00,
            7.00
    };
    private int[] codigo = {
            3847, 9271, 4120, 6352, 1049, 7630, 5913, 8475,
            1782, 3269, 7503, 4930, 2094, 6841, 3728, 9586,
            2471, 6015, 7109, 1654, 8137, 5396, 6921,
            4305, 2951, 8742, 3649, 7012, 1207,
            9860
    };

    public Pedido() {
        System.out.println("Solo se pueden añadir " + MAX_PEDIDO + " productos al pedido.");
        productos = new Producto[MAX_PEDIDO];
        cantidadPedido = 0;
    }

    public void añadirProductosPedido(Producto producto) {
        if (cantidadPedido < productos.length) {
            productos[cantidadPedido] = producto;
            cantidadPedido++;
            System.out.println("Producto añadido al pedido: " + producto);
        } else {
            System.out.println("El pedido está lleno. No se pueden añadir más productos.");
        }
    }

    public void mostrarProductosDisponibles() {
        System.out.println("Productos disponibles:");
        for (int i = 0; i < nombre.length; i++) {
            System.out.println(nombre[i] + " - Precio: " + precio[i] + "$");
        }
    }

    public void mostrarPedido() {
        if (cantidadPedido == 0) {
            System.out.println("El pedido está vacío.");
        } else {
            for (int i = 0; i < cantidadPedido; i++) {
                System.out.println(productos[i]);
            }
            System.out.println("Total: " + calcularTotal() + "$");
        }
    }

    public double calcularTotal() {
        double total = 0;
        for (int i = 0; i < cantidadPedido; i++) {
            total += productos[i].getPrecio();
        }
        return total;
    }

    public String[] getNombre() {
        return nombre;
    }

    public double[] getPrecio() {
        return precio;
    }

    public int[] getCodigo() {
        return codigo;
    }

    public Producto[] getProductosComprados() {
        Producto[] productosComprados = new Producto[cantidadPedido];
        for (int i = 0; i < cantidadPedido; i++) {
            productosComprados[i] = productos[i];
        }
        return productosComprados;
    }

    public void vaciarPedido() {
        productos = new Producto[MAX_PEDIDO];
        cantidadPedido = 0;
    }
}
