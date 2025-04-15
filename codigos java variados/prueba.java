import java.util.Scanner;

class prueba {
    public static void main(String[] args){
    Scanner scanner = new Scanner(System.in);

    int numero1, numero2;
    System.out.println("----- CALCULADORA -----");
    System.out.println("Introduce el primer digito");
    numero1 = scanner.nextInt();
    System.out.println("Introduce el segundo digito");
    numero2 = scanner.nextInt();
    System.out.println("------------------------------");

    int operacion;
    System.out.println("Introduzca que operacion desea realizar: ");
    System.out.println("1. Suma");
    System.out.println("2. Resta");
    System.out.println("3. Multiplicacion");
    System.out.println("4. Division");
    operacion = scanner.nextInt();

    if (operacion==1) {
        System.out.println("=====================");
        System.out.println("LA SOLUCIÓN ES: " + (numero1+numero2));
        System.out.println("=====================");
    } else if (operacion==2) {
        System.out.println("=====================");
        System.out.println("LA SOLUCIÓN ES: " + (numero1-numero2));
        System.out.println("=====================");
    } else if (operacion==3) {
        System.out.println("=====================");
        System.out.println("LA SOLUCIÓN ES: " + (numero1*numero2));
        System.out.println("=====================");
    } else if (operacion==4){
        if (numero2!=0){
            System.out.println("=====================");
            System.out.println("LA SOLUCIÓN ES: " + (numero1/numero2));
            System.out.println("=====================");
        } else if (numero2==0){
            System.out.println("=====================");
            System.out.println("Imposible de calcular");
            System.out.println("=====================");
        }
    } else if (operacion!=1 || operacion!=2 || operacion!=3 || operacion!=4)
        System.out.println("Has introducido un valor erroneo, vuelve a introducir un número");

    scanner.close();
    }
    
} 