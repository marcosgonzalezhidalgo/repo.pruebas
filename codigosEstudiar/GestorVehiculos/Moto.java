package codigosEstudiar.GestorVehiculos;

public class Moto extends Vehiculo{
    public static final String[] MARCAS_DISPONIBLES = {"Yamaha", "Honda", "Kawasaki", "Suzuki", "Ducati"};
    public static final String[] TIPOS_DISPONIBLES = {"Deportiva", "Cruiser", "Touring", "Scooter", "Dual-sport"};
    public static final String[] AÑOS_DISPONIBLES = {"2001", "2005", "2010", "2015", "2020"};

    public Moto(String marca, String tipo, String año, String color) {
        super(marca, tipo, año, color);
    }

    public static void mostrarOpciones() {
        System.out.println("Opciones de Moto:");
    
        System.out.println("Marcas disponibles: ");
        int contador = 1;
        for (String marca : MARCAS_DISPONIBLES) {
            System.out.println(contador++ + ". " + marca);
        }
    
        System.out.println("Tipos disponibles: ");
        contador = 1;
        for (String tipo : TIPOS_DISPONIBLES) {
            System.out.println(contador++ + ". " + tipo);
        }
    
        System.out.println("Años disponibles: ");
        contador = 1;
        for (String año : AÑOS_DISPONIBLES) {
            System.out.println(contador++ + ". " + año);
        }
    
        System.out.println("Colores disponibles: ");
        contador = 1;
        for (String color : COLORES_DISPONIBLES) {
            System.out.println(contador++ + ". " + color);
        }
    }

    public String getMarca(int index) {
        if (index >= 0 && index < MARCAS_DISPONIBLES.length) {
            return MARCAS_DISPONIBLES[index];
        } else {
            return "Índice fuera de rango";
        }
    }

    public String getTipo(int index) {
        if (index >= 0 && index < TIPOS_DISPONIBLES.length) {
            return TIPOS_DISPONIBLES[index];
        } else {
            return "Índice fuera de rango";
        }
    }

    public String getAño(int index) {
        if (index >= 0 && index < AÑOS_DISPONIBLES.length) {
            return AÑOS_DISPONIBLES[index];
        } else {
            return "Índice fuera de rango";
        }
    }

    public String getColor(int index) {
        if (index >= 0 && index < COLORES_DISPONIBLES.length) {
            return COLORES_DISPONIBLES[index];
        } else {
            return "Índice fuera de rango";
        }
    }

    @Override
    public void mostrarInformacion() {
        System.out.println("Marca: " + marca);
        System.out.println("Tipo: " + tipo);
        System.out.println("Año: " + año);
        System.out.println("Color: " + color);
    }

}
