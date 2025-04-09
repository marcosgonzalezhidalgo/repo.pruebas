package codigosEstudiar.AplicacionComida;

public class Pedido {
    private Plato[] platosPedido;
    private int cantidadPlatos;

    public Pedido() {
        platosPedido = new Plato[10]; 
        cantidadPlatos = 0;
    }

    public void agregarPlato(Plato plato) {
        if (cantidadPlatos < platosPedido.length) {
            platosPedido[cantidadPlatos] = plato;
            cantidadPlatos++;
        } else {
            System.out.println("No se pueden agregar más platos al pedido.");
        }
    }

    public double calcularTotal() {
        double total = 0;
        for (int i = 0; i < cantidadPlatos; i++) {
            total += platosPedido[i].getPrecio();
        }
        return total;
    }

    public void mostrarResumen() {
        System.out.println("----- RESUMEN DEL PEDIDO -----");
        for (int i = 0; i < cantidadPlatos; i++) {
            System.out.println(platosPedido[i]);
        }
        System.out.printf("Total a pagar: $%.2f\n", calcularTotal());
    }
}
