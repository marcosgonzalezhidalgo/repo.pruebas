package codigosEstudiar.SimuladorFinanciero;

public class Dinero {
    private Cliente cliente;
    private Banco banco;
    public int añadirDineroAleatorio;
    public int añadirDineroFijo;

    public Dinero(Cliente cliente, Banco banco) {
        this.cliente = cliente;
        this.banco = banco;
    }

    public int añadirCantidadDineroFija(int cantidad) {
        this.añadirDineroFijo = cantidad;
        return añadirDineroFijo;
    }
    
    public int añadirCantidadDineroAleatoria() {
        añadirDineroAleatorio = (int) (Math.random() * (99999999 + 10000000)) + 10000000;
        return añadirDineroAleatorio;
    }

    public int añadirDineroAlBanco() {
        int cantidadDinero = añadirDineroAleatorio + añadirDineroFijo;
        banco.añadirDinero(cantidadDinero);
        return cantidadDinero;
    }

    public int getCantidadDineroDelBanco(int cantidadDinero) {
        return banco.cantidadDineroDelBanco(cantidadDinero);
    }

    public String getBancoUsuario() {
        return banco.getBancoUsuario();
    }

    public String getCliente() {
        return cliente.getNombre() + " " + cliente.getApellido();
    }

    public String toStringDineroAñadido() {
        if (añadirDineroFijo !=0){
        return "El cliente " + cliente.getNombre() + " " + cliente.getApellido() + " ha añadido " + añadirDineroFijo + "€ al banco " + banco.getBancoUsuario();
        } else {
            return "El cliente " + cliente.getNombre() + " " + cliente.getApellido() + " ha añadido " + añadirDineroAleatorio + "€ al banco " + banco.getBancoUsuario();
        }
    
    }
}
