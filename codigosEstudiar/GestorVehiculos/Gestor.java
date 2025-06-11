package codigosEstudiar.GestorVehiculos;

import java.util.Scanner;

public class Gestor {
    public static void main(String[] args) {
        iniciarVehiculos();

    }

    public static void iniciarVehiculos() {
        System.out.println("Bienvenido al Gestor de Vehículos");
        System.out.println("Que desea comprar? \n1. Coche\n2. Moto\n3. Camión");
        Scanner scanner = new Scanner(System.in);
        int opcion = scanner.nextInt();

        if (opcion == 1) {
            Vehiculo coche = crearVehiculo("coche");
            coche.mostrarInformacion();
        } else if (opcion == 2) {
            Vehiculo moto = crearVehiculo("moto");
            moto.mostrarInformacion();
        } else if (opcion == 3) {
            Vehiculo camion = crearVehiculo("camion");
            camion.mostrarInformacion();
        } else {
            System.out.println("Opción no válida. Por favor, intente de nuevo.");
        }

        scanner.close();
    }

    public static Vehiculo crearVehiculo(String type) {
        Scanner scanner = new Scanner(System.in);
        String marca = "", modelo = "", color = "";
        String año = "";

        switch (type.toLowerCase()) {
            case "coche":
                Coche.mostrarOpciones();
                System.out.println("Seleccione la marca (1-5): ");
                marca = Coche.MARCAS_DISPONIBLES[scanner.nextInt() - 1];
                System.out.println("Seleccione el tipo (1-5): ");
                modelo = Coche.TIPOS_DISPONIBLES[scanner.nextInt() - 1];
                System.out.println("Seleccione el año (1-5): ");
                año = Coche.AÑOS_DISPONIBLES[scanner.nextInt() - 1];
                System.out.println("Seleccione el color (1-5): ");
                color = Coche.COLORES_DISPONIBLES[scanner.nextInt() - 1];
                System.out.println("===========================");

                return new Coche(marca, modelo, año, color);

            case "moto":
                Moto.mostrarOpciones();
                System.out.println("Seleccione la marca (1-5): ");
                marca = Moto.MARCAS_DISPONIBLES[scanner.nextInt() - 1];
                System.out.println("Seleccione el tipo (1-5): ");
                modelo = Moto.TIPOS_DISPONIBLES[scanner.nextInt() - 1];
                System.out.println("Seleccione el año (1-5): ");
                año = Moto.AÑOS_DISPONIBLES[scanner.nextInt() - 1];
                System.out.println("Seleccione el color (1-5): ");
                color = Moto.COLORES_DISPONIBLES[scanner.nextInt() - 1];
                System.out.println("===========================");

                return new Moto(marca, modelo, año, color);

            case "camion":
                Camion.mostrarOpciones();
                System.out.println("Seleccione la marca (1-5): ");
                marca = Camion.MARCAS_DISPONIBLES[scanner.nextInt() - 1];
                System.out.println("Seleccione el tipo (1-5): ");
                modelo = Camion.TIPOS_DISPONIBLES[scanner.nextInt() - 1];
                System.out.println("Seleccione el año (1-5): ");
                año = Camion.AÑOS_DISPONIBLES[scanner.nextInt() - 1];
                System.out.println("Seleccione el color (1-5): ");
                color = Camion.COLORES_DISPONIBLES[scanner.nextInt() - 1];
                System.out.println("===========================");

                return new Camion(marca, modelo, año, color);

            default:
                System.out.println("Tipo no reconocido.");
                return null;
        }
    }

}