package codigosEstudiar.SimuladorFinanciero;

public class Banco {
    private Cliente cliente;
    private String nombreBanco;
    private int codigoBanco;
    private String[] bancos = {
        "Banco Áureo", "Banco Solaris", "Banco Terranova", "Banco Centuria", 
        "Banco Lumen", "Banco Horizonte", "Banco Nova", "Banco Vértice", 
        "Banco Boreal", "Banco Elíseo"
    };
    int numeroAleatorio = (int) (Math.random() * 10);
    private int[] codigos = new int[bancos.length];
    private int[] cantidadDineroBanco = new int[bancos.length];
    
    public Banco(Cliente cliente){
        this.cliente = cliente;
        codigos = getCodigosAleatorios(codigos);
        this.nombreBanco = bancos[numeroAleatorio];
        this.codigoBanco = codigos[numeroAleatorio];
    }

    public int[] getCodigosAleatorios(int[] codigos) {
        for (int i = 0; i < codigos.length; i++) {
            codigos[i] = (int) (Math.random() * (9999999 + 1000000)) + 1000000;
        }
        return codigos;
    }

    public String getBancoUsuario() {
        return nombreBanco + " - " + codigoBanco;
    }

    public int cantidadDineroDelBanco(int cantidadDinero) {
       return cantidadDineroBanco[numeroAleatorio];

    }

    public String toString(){
        return "Banco del usuario "+ cliente.getNombre() + " " + cliente.getApellido() + ": " + getBancoUsuario();
    }

    public void añadirDinero(int cantidadDinero) {
        cantidadDineroBanco[numeroAleatorio] += cantidadDinero;
    }

    public String toStringDineroBanco(){
        return "El banco " + getBancoUsuario() + " tiene " + cantidadDineroBanco[numeroAleatorio] + "€";
    }
}
