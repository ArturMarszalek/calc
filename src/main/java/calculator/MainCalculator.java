package calculator;

import java.util.Scanner;

public class MainCalculator {
    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        Scanner scanner = new Scanner(System.in);
        boolean loop = true;

        while (loop) {

            System.out.println();

            System.out.println("Wybierz komendę:");
            System.out.println("exit - zakończenie programu");
            System.out.println("total - pobierz wynik z kalkulatora");
            System.out.println("[+ - * /] [liczba]");


            System.out.println();

            String command = scanner.nextLine();

            switch (command) {

                case "exit":
                    loop = false;
                    System.out.println("Kalkulator zakonczyl prace!");
                    break;
                case "total":
                    System.out.println("Wynik: " + calculator.getResult());
                    break;
                default:
                    try {
                        calculator.execute(command);
                        System.out.println("Dzialanie zostało wykonane!");
                    } catch (UnsupportedCalculatorOperationException e) {
                        System.out.println("Niewłaściwa komenda!");
                    } catch (Exception e) {
                        System.out.println("Cos poszlo nie tak!! Blad programu");
                        System.out.println(e.getMessage());
                    }

                    break;

            }


        }

    }


}