package calculator;


import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        System.out.println("Witaj w magicznym kalkulatorze!");
        System.out.println("Działanie: ");

        Calculator calculator = new Calculator();
        Scanner scanner = new Scanner(System.in);


        while (scanner.hasNext()) {
            try {
                String userChoice = scanner.nextLine();

                if (userChoice.equals("exit")) {
                    System.exit(0);
                } else if (userChoice.equals("total")) {
                    System.out.println(calculator.getTotal());
                } else {
                    double result = calculator.execute(userChoice);
                }
            } catch (Exception e) {
                System.out.println("Wpisaono niepoprawną komendę");
            }
        }
    }
}