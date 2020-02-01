import calculator.Calculator;
import calculator.UnsuportedCommandException;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Calculator calculator = new Calculator();

        try {
            while (true) {
                System.out.println("Proszę podać działanie i liczbę ");
                Scanner sc = new Scanner(System.in);
                String command = sc.nextLine();
                if (command.equals("exit")) {
                    System.out.println(calculator.getValue());
                    break;
                }
                calculator.validation(command);
                System.out.println("Wynik: " + calculator.getValue());
            }
        } catch (UnsuportedCommandException e) {
            System.out.println("Nie poprawny format");
            System.out.println("Dotychczasowy rezultat to: " + calculator.getValue());

        }



    }



}

