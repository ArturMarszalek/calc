package calculator;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws UnsupportedCalculatorOperationException {

        Calculator calculator = new Calculator();

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Działanie:");
            String dzialanie = scanner.nextLine();
            if (dzialanie.equals("exit")) {
                break;
            }
            if (dzialanie.equals("total")) {
                calculator.total();
            }
            try {
                System.out.println(calculator.execute(dzialanie));
            }catch (UnsupportedCalculatorOperationException e){
                System.out.println("Błąd, coś poszło nie tak. Wpisz znak, spacje oraz liczbę.");
            }
        }

    }
}