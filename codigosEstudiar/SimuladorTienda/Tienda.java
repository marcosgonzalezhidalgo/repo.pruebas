package codigosEstudiar.SimuladorTienda;

import java.util.Scanner;

public class Tienda {

    public static void main(String[] args) {
        Tienda tienda = new Tienda();
        Almacen almacen = new Almacen();
        Cliente[] clientes = new Cliente[Cliente.MAX_CLIENTES];

        tienda.realizarPedido(almacen);

        almacen.mostrarInventario();

        tienda.generarClientes(clientes);

        tienda.esogerClienteAleatorio(clientes);

        tienda.clienteAñadirProductosAleatoriosAlCarrito(almacen, 3);

        tienda.elegido.mostrarCarrito();
    }

    private Pedido pedido;
    private Scanner scanner = new Scanner(System.in);
    private Cliente elegido;

    public Tienda() {
        pedido = new Pedido();
    }

    public void realizarPedido(Almacen almacen) {
        boolean pidiendo = true;
        System.out.println("Solo se pueden añadir " + Pedido.MAX_PEDIDO + " productos al pedido.");

        while (pidiendo) {
            mostrarMenu();
            int opcion = scanner.nextInt();
            pidiendo = procesarOpcion(opcion, almacen);
        }
    }

    private void mostrarMenu() {
        System.out.println("¿Qué desea hacer?");
        System.out.println("1. Añadir productos al pedido");
        System.out.println("2. Ver productos en el pedido");
        System.out.println("3. Comprar productos");
        System.out.println("4. Salir");
    }

    private boolean procesarOpcion(int seleccion, Almacen almacen) {
        switch (seleccion) {
            case 1 -> añadirProductos();
            case 2 -> pedido.mostrarPedido();
            case 3 -> {
                if (pedido.cantidadPedido == 0) {
                    System.out.println("No hay productos en el pedido.");
                } else {
                    System.out.println("Productos comprados:");
                    for (int i = 0; i < pedido.cantidadPedido; i++) {
                        Producto comprado = pedido.getProductosComprados()[i];
                        System.out.println(comprado);
                        almacen.añadirAlInventario(comprado);
                    }
                    System.out.println("Total: " + pedido.calcularTotal() + "$");
                    pedido.vaciarPedido();
                }
            }
            case 4 -> {
                System.out.println("Saliendo...");
                return false;
            }
            default -> System.out.println("Opción inválida.");
        }
        return true;
    }

    private void añadirProductos() {
        boolean eligiendo = true;
        pedido.mostrarProductosDisponibles();
        while (eligiendo) {
            if (pedido.cantidadPedido >= Pedido.MAX_PEDIDO) {
                System.out.println("No puedes añadir más productos.");
                break;
            }

            System.out.println("Seleccione el producto (0 para salir):");
            int opcion = scanner.nextInt();

            if (opcion == 0) {
                eligiendo = false;
            } else if (opcion >= 1 && opcion <= 30) {
                Producto producto = new Producto(
                        pedido.getNombre()[opcion - 1],
                        pedido.getPrecio()[opcion - 1],
                        pedido.getCodigo()[opcion - 1]);
                pedido.añadirProductosPedido(producto);
            } else {
                System.out.println("Opción inválida.");
            }
        }
    }

    private Cliente[] generarClientes(Cliente[] clientes) {

        for (int i = 0; i < clientes.length; i++) {
            String nombreAleatorio = Cliente.getNombreAleatorio();
            clientes[i] = new Cliente(nombreAleatorio);
        }

        return clientes;
    }

    private void esogerClienteAleatorio(Cliente[] clientes) {
        int clienteActual = (int) (Math.random() * Cliente.MAX_CLIENTES);
        elegido = clientes[clienteActual];
        System.out.println("Cliente elegido: " + elegido.getNombre());
    }

    private void clienteAñadirProductosAleatoriosAlCarrito(Almacen almacen, int cantidad) {
        Producto[] inventario = almacen.getInventario();
        int añadidos = 0;
        while (añadidos < cantidad) {
            int indiceAleatorio = (int) (Math.random() * inventario.length);
            Producto producto = inventario[indiceAleatorio];

            if (producto != null) {
                elegido.getCarrito().añadirProductos(producto);
                System.out.println("Producto añadido al carrito: " + producto.getNombre());
                añadidos++;
            }
        }
    }
}