package codigosEstudiar.SimuladorFinanciero;

public class App {

    final static int CANTIDAD_CLIENTES = 2;
    final static int INVERSION_MINIMA = 10000;
    public static void main(String[] args) {
        Cliente cliente[] = new Cliente[CANTIDAD_CLIENTES];
        cliente[0] = new Cliente("Juan", "Gómez", null , null, null);
        cliente[1] = new Cliente("Pedro", "Pérez", null , null, null);

        Banco banco[] = new Banco[CANTIDAD_CLIENTES];
        for (int i = 0; i < CANTIDAD_CLIENTES; i++) {
            banco[i] = new Banco(cliente[i]);
        }

        Dinero dinero[] = new Dinero[CANTIDAD_CLIENTES];
        for (int i = 0; i < CANTIDAD_CLIENTES; i++) {
            dinero[i] = new Dinero(cliente[i], banco[i]);
        }

        Inversiones inversiones[] = new Inversiones[CANTIDAD_CLIENTES];
        for (int i = 0; i < CANTIDAD_CLIENTES; i++) {
            inversiones[i] = new Inversiones(dinero[i], banco[i], cliente[i]);
        }

        for (int i = 0; i < CANTIDAD_CLIENTES; i++) {
            banco[i].getBancoUsuario();
        }
        dinero[0].añadirCantidadDineroFija(9999999);
        dinero[1].añadirCantidadDineroAleatoria();
        

        añadirDineroABancos(dinero);

        imprimirUsuarioBanco(cliente, banco);

        imprimirDineroAñadido(dinero);
        imprimirDineroBanco(banco);

        invertirMinimoTodosLosClientes(inversiones);
        imprimirDineroBanco(banco);
    }

    public static void imprimirUsuarioBanco(Cliente cliente[], Banco banco[]) {
        System.out.println("-------------------------------------------------");
        for (int i = 0; i < CANTIDAD_CLIENTES; i++) {
            System.out.println(cliente[i].toString());
            System.out.println(".................................................");
            System.out.println(banco[i].toString());
            System.out.println("=================================================");
        }
    }

    public static void imprimirDineroBanco(Banco banco[]) {
        for (int i = 0; i < CANTIDAD_CLIENTES; i++) {
            System.out.println(banco[i].toStringDineroBanco());
            System.out.println("-------------------------------------------------");
        }
    }

    public static void imprimirDineroAñadido(Dinero dinero[]) {
        for (int i = 0; i < CANTIDAD_CLIENTES; i++) {
            System.out.println(dinero[i].toStringDineroAñadido());
            System.out.println("-------------------------------------------------");
        }
    }

    public static void añadirDineroABancos(Dinero[] dinero) {
        for (int i = 0; i < dinero.length; i++) {
            dinero[i].añadirDineroAlBanco();
        }
    }

    public static void invertirMinimoTodosLosClientes(Inversiones[] inversiones) {
        for (int i = 0; i < CANTIDAD_CLIENTES; i++) {
            inversiones[i].invertirDinero(INVERSION_MINIMA);
            inversiones[i].getInversionAleatoria();
            inversiones[i].devolverDineroAlBanco();
            System.out.println(inversiones[i].toStringInversion());
            System.out.println(inversiones[i].toStringInversionGanadaPerdida());
            System.out.println("-------------------------------------------------");        }
    }

}