package br.edu.uniamerica.projetomensal.utils;

import java.util.Scanner;

public class InputUtils {
    public static int lerInt(Scanner sc, String mensagem) {
        while(true) {
            try {
                System.out.print(mensagem);
                return Integer.parseInt(sc.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Entrada invalida. Por favor, digite um numero inteiro.");
            }
        }
    }

    public static double lerDouble(Scanner sc, String mensagem) {
        while(true) {
            try {
                System.out.print(mensagem);
                return Double.parseDouble(sc.nextLine().replace(",", "."));
            } catch (NumberFormatException e) {
                System.out.println("Entrada invalida. Por favor, digite um numero valido.");
            }
        }
    }

    public static String lerString(Scanner sc, String mensagem) {
        while(true) {
            try {
                System.out.print(mensagem);
                return sc.nextLine();
            } catch (NumberFormatException e) {
                System.out.println("Entrada invalida. Por favor, digite um texto valido.");
            }
        }

    }
}
