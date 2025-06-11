package codigosEstudiar.Biblioteca;

import java.util.Scanner;

public class ClienteBiblioteca {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Usuario usuario = Biblioteca.preguntarPersona(scanner);

        Biblioteca.iniciarBiblioteca(scanner, usuario);
    }
}
