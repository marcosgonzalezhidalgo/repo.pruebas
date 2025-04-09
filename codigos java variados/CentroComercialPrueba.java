import java.util.Scanner;

class CentroComercialPrueba {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);

        final int HORA_ABRE = 9;
        final int HORA_CIERRA = 21;
        final int TIEMPO_TOTAL = (HORA_ABRE - HORA_CIERRA) * 60;
        final double PROBABILIDAD_CLIENTE = 0.6;

        int tiempoActual = 1;
        int fila = 0;
        int productos = (int) (Math.random() * (15 - 5 + 1) + 5);
        int cliente = 0;
        int caja1 = 0, caja2 = 0, caja3 = 0, caja4 = 0;

        for (tiempoActual = 1; tiempoActual <= TIEMPO_TOTAL; tiempoActual++) {
            int llegaAlguien = Math.random() <= PROBABILIDAD_CLIENTE ? 1 : 0;
            fila = fila + llegaAlguien;
            System.out.println(tiempoActual + " - Llega " + llegaAlguien + " persona - En cola: " + fila);

            int[] cajas = { caja1, caja2, caja3, caja4 };
            for (int i = 0; i < 4; i++) {
                if (cajas[i] <= 0 && fila > 0) {
                    fila--;
                    cajas[i] = (int) (Math.random() * (15 - 5 + 1) + 5);
                }
            }

            caja1 = cajas[0];
            caja2 = cajas[1];
            caja3 = cajas[2];
            caja4 = cajas[3];

            for (int i = 0; i < 4; i++){
                if (cajas[i] > 0) {
                    cajas[i] = cajas[i] - 1;
                }

            caja1 = cajas[0];
            caja2 = cajas[1];
            caja3 = cajas[2];
            caja4 = cajas[3];

            }

            System.out.println("Caja 1: "+caja1+" | Caja 2: "+caja2+" | Caja 3: "+caja3+" | Caja 4: "+caja4);
            System.out.println("------------------------------------------------------------------------------");
        }

    }
}