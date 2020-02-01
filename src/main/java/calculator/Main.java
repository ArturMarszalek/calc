package calculator;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Podaj działanie: ");

        while (true) {
            String userChoice = scanner.nextLine();


            try {
                System.out.println("Wynik działania " + calculator.execute(userChoice));

                if (userChoice.equals("total")) {
                    calculator.total();
                    continue;
                }

                if (userChoice.equals("exit")) {
                    break;
                }
            } catch (Exception e) {
                System.out.println("Coś poszło nie tak");


            }


        }
    }
}
