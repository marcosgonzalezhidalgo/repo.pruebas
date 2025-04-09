package codigosEstudiar.AplicacionComida;
import java.util.Random;


public class Menu {
    private Plato[] platos;
    private String[] nombres = {
        "Pizza", "Hamburguesa", "Ensalada", "Pasta", "Sopa",
        "Taco", "Sándwich", "Sushi", "Pollo Asado", "Arroz Frito",
        "Burrito", "Ceviche", "Lasaña", "Empanada", "Ramen",
        "Panqueques", "Croquetas", "Falafel", "Paella", "Arepa",
        "Quesadilla", "Gyoza", "Tarta de Manzana", "Helado", "Gazpacho",
        "Milanesa", "Tortilla Española", "Churrasco", "Polenta", "Canelones"
    };
    
    private double[] precios = {
        10.99, 8.99, 7.99, 12.99, 5.99,
        3.49, 4.99, 13.99, 9.99, 6.49,
        7.99, 11.49, 12.49, 2.99, 9.49,
        5.49, 4.29, 6.79, 14.99, 3.99,
        6.59, 5.89, 4.79, 3.49, 4.19,
        10.59, 7.89, 13.79, 5.39, 11.29
    };

    public Menu() {
        platos = new Plato[5]; 
        Random random = new Random();

        for (int i = 0; i < platos.length; i++) {
            int index = random.nextInt(nombres.length);
            platos[i] = new Plato(nombres[index], precios[index]);
        }
    }

    public void MostrarMenu() {
        System.out.println("----- Menú -----");
        for (Plato plato : platos) {
            System.out.println(plato);
        }
    }

    public Plato obtenerPlato(int indice) {
        if (indice >= 0 && indice < platos.length) {
            return platos[indice];
        } else {
            return null;
        }
    }
}



