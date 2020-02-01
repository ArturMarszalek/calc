package calculator;


import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        System.out.println("Witaj w magicznym kalkulatorze!");
        System.out.println("Działanie: ");

        Calculator calculator = new Calculator();
        Scanner scanner = new Scanner(System.in);

        try {
            while (scanner.hasNext()) {
                String userChoice = scanner.nextLine();
                if (userChoice.equals("exit")) {
                    System.exit(0);
                }
                double result = calculator.execute(userChoice);
                System.out.println(result);

            }

        } catch(Exception e){
            System.out.println("Wpisaono niepoprawną komendę");
        }
    }
}