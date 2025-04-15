package codigosEstudiar.AplicacionVotaciones;
import java.util.Scanner;

public class App {

    public static void main(String[] args) {
        Votante votante = iniciarAplicacion();
        System.out.println(votante.toStringVotante());
    }

    public static Votante iniciarAplicacion() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Bienvenido a la aplicación de votaciones");
        System.out.println("Por favor, ingrese sus datos personales:");
        
        System.out.print("Nombre: ");
        while (!scanner.hasNextLine()) {
            System.out.print("Por favor, ingrese un nombre válido: ");
            scanner.next(); 
        }
        String nombre = scanner.nextLine();
        
        System.out.print("Apellido: ");
        while (!scanner.hasNextLine()) {
            System.out.print("Por favor, ingrese un apellido válido: ");
            scanner.next(); 
        }
        String apellido = scanner.nextLine();
        
        System.out.print("DNI: ");
        while (!scanner.hasNextLine()) {
            System.out.print("Por favor, ingrese un DNI válido: ");
            scanner.next(); 
        }
        String dni = scanner.nextLine();
        
        System.out.print("Edad: ");
        while (!scanner.hasNextLine()) {
            System.out.print("Por favor, ingrese una edad válida: ");
            scanner.next(); 
        }
        while (!scanner.hasNextInt()) {
            System.out.print("Por favor, ingrese una edad válida: ");
            scanner.next(); 
        }
        int edad = scanner.nextInt();
        scanner.nextLine(); 
        
        System.out.print("Dirección: ");
        while (!scanner.hasNextLine()) {
            System.out.print("Por favor, ingrese una dirección válida: ");
            scanner.next(); 
        }
        String direccion = scanner.nextLine();
        
        System.out.print("Teléfono: ");
        while (!scanner.hasNextInt()) {
            System.out.print("Por favor, ingrese un teléfono válido: ");
            scanner.next(); 
        }
        int telefono = scanner.nextInt();
        scanner.nextLine(); 
        
        System.out.print("Correo Electrónico: ");
        while (!scanner.hasNextLine()) {
            System.out.print("Por favor, ingrese un correo electrónico válido: ");
            scanner.next(); 
        }
        String correoElectronico = scanner.nextLine();

        scanner.close();
        
        return new Votante(nombre, apellido, dni, edad, direccion, telefono, correoElectronico);
    }
}