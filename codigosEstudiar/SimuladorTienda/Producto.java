package codigosEstudiar.SimuladorTienda;

public class Producto {
    private String nombre;
    private double precio;
    private int codigo;

    public Producto(String nombre, double precio, int codigo){
        this.nombre = nombre;
        this.precio = precio;
        this.codigo = codigo;
    }
    
    public String getNombre(){
        return nombre;
    }

    public double getPrecio(){
        return precio;
    }

    public int getCodigo(){
        return codigo;
    }

    public String toString(){
        return nombre + " - $" + precio + " - Código: " + codigo;
    }
}
