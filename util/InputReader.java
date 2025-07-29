package suppliersystem.util;

import java.util.Scanner;

public class InputReader {
    public static String readNonEmptyString(Scanner input, String fieldName) {
        String value;
        do {
            System.out.print(fieldName + ": ");
            value = input.nextLine();
            if (value.trim().isEmpty()) {
                System.out.println("Nenhum valor inserido.");
            }
        } while (value.trim().isEmpty());
        return value;
    }

    public static double readPositiveDouble(Scanner input, String fieldName) {
        double value = -1;
        while (value <= 0) {
            System.out.print(fieldName + ": ");
            if (input.hasNextDouble()) {
                value = input.nextDouble();
                if (value <= 0) {
                    System.out.println("Insira um valor positivo.");
                }
            } else {
                System.out.println("Valor inválido. Insira um número.");
                input.next();
            }
        }
        input.nextLine();
        return value;
    }
}