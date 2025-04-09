package codigosEstudiar.AplicacionComida;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Menu menu = new Menu();
        Pedido pedido = new Pedido();

        int opcion;

        System.out.println("¡Bienvenido al sistema de pedidos!");

        do {
            menu.MostrarMenu();
            System.out.print("Elige el número del plato (0 para finalizar pedido): ");
            opcion = scanner.nextInt();

            if (opcion > 0 && opcion <= 5) {
                Plato platoSeleccionado = menu.obtenerPlato(opcion - 1);
                pedido.agregarPlato(platoSeleccionado);
                System.out.println(platoSeleccionado.getNombre() + " añadido al pedido.\n");
            } else if (opcion != 0) {
                System.out.println("Opción no válida. Intenta de nuevo.\n");
            }

        } while (opcion != 0);

        pedido.mostrarResumen();
        scanner.close();
    }
}
