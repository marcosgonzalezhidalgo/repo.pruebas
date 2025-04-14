package codigosEstudiar.SimuladorFinanciero;

public class Inversiones {
    Dinero dinero;
    Banco banco;
    Cliente cliente;
    private int cantidadDineroInvertida;
    private int cantidadDineroRecibido;
    private int cantidadDineroGanado;
    private int cantidadDineroPerdido;
    private String nombreInversion;

    private String[] inversion = {
        "Acciones", "Bonos", 
        "Fondos de Inversión", "Bienes Raíces", 
        "Criptomonedas", "Materias Primas", 
        "Cuentas de Ahorro", "Planes de Pensiones"
    };
    private double[] porcentajesGanancia = {
        0.05, 0.03, 
        0.07, 0.04, 
        0.10, 0.02, 
        0.01, 0.06
    };
    private double[] porcentajesPerdida = {
        0.02, 0.01, 
        0.03, 0.02, 
        0.05, 0.01, 
        0.00, 0.04
    };
    private int numeroAleatorio = (int) (Math.random() * 8);

    public Inversiones(Dinero dinero, Banco banco, Cliente cliente) {
        this.dinero = dinero;
        this.banco = banco;
        this.cliente = cliente;
        this.nombreInversion = inversion[numeroAleatorio];
    }

    public int invertirDinero(int cantidadDineroInvertida) {
        this.cantidadDineroInvertida = cantidadDineroInvertida;
        banco.disminuirCantidadDineroBanco(cantidadDineroInvertida);
        return cantidadDineroInvertida;
    }

    public String getNombreInversion(){
        return nombreInversion;
    }

    public int getInversionAleatoria(){
        int decision = (int) (Math.random() * 2);
        if (decision == 0) {
            cantidadDineroGanado = (int) (cantidadDineroInvertida * porcentajesGanancia[numeroAleatorio]);
            cantidadDineroRecibido = cantidadDineroInvertida + cantidadDineroGanado;
            return cantidadDineroRecibido;
        } else {
            cantidadDineroPerdido = (int) (cantidadDineroInvertida * porcentajesPerdida[numeroAleatorio]);
            cantidadDineroRecibido = cantidadDineroInvertida - cantidadDineroPerdido;
            return cantidadDineroRecibido;
        }
    }

    public String toStringInversion() {
        return "El cliente " + cliente.getNombre() + " " + cliente.getApellido() + " ha invertido " + cantidadDineroInvertida + "€ en " + nombreInversion;
    }

    public String toStringInversionGanadaPerdida() {
        if (cantidadDineroGanado != 0) {
            return "El cliente " + cliente.getNombre() + " " + cliente.getApellido() + " ha ganado " + cantidadDineroGanado + "€ en la inversión de " + nombreInversion;
        } else {
            return "El cliente " + cliente.getNombre() + " " + cliente.getApellido() + " ha perdido " + cantidadDineroPerdido + "€ en la inversión de " + nombreInversion;
        }
    }

    public int devolverDineroAlBanco(){
        banco.aumentarCantidadDineroBanco(cantidadDineroRecibido);
        return cantidadDineroRecibido;
    }

    public String toStringDineroRecibido() {
        return "El cliente " + cliente.getNombre() + " " + cliente.getApellido() + " ha recibido " + cantidadDineroRecibido + "€ de la inversión de " + nombreInversion;
    }


}
