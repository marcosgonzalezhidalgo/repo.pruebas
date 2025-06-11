package codigosEstudiar.GestorVehiculos;

public abstract class Vehiculo {
    protected String marca;
    protected String tipo;
    protected String año;
    protected String color;


    public static final String[] COLORES_DISPONIBLES = {"Rojo", "Azul", "Negro", "Blanco", "Gris"};

    public Vehiculo(String marca, String modelo, String año, String color) {
        this.marca = marca;
        this.tipo = modelo;
        this.año = año;
        this.color = color;
    }


    public abstract void mostrarInformacion();
}
