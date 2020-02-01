package calculator;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Calculator calculator = new Calculator();
        Scanner scanner = new Scanner(System.in);
        boolean loop = true;

        System.out.println();

        System.out.println("=============================================");

        System.out.println("Wybierz komendę:");
        System.out.println("exit - zakończenie programu");
        System.out.println("total - pobiera wynik z kalkulatora");
        System.out.println("[+ - * /] [liczba]");

        System.out.println("=============================================");

        System.out.println();

        while (loop) {

            String command = scanner.nextLine();

            switch (command) {

                case "exit":
                    loop = false;
                    System.out.println("Zakończono pracę kalkulatora!");
                    break;
                case "total":
                    System.out.println("Wynik: " + calculator.getResult());
                    break;
                default:
                    calculator.execute(command);
                    break;

            }


        }

    }

}
