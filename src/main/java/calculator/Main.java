package calculator;

import java.util.Scanner;

public class Main {
    public static void main(String[] args){

        Scanner scanner = new Scanner(System.in);
        Calculator calculator = new Calculator();
        boolean shouldQuit=false;

        while (!shouldQuit) {
            System.out.print("Wprowadź działanie : ");

            try {
                String operation = scanner.nextLine();
                if (operation.equals("exit")) {
                    break;
                }
                System.out.println("\nWynik = "+calculator.execute(operation));
            } catch (UnsupportedCalculatorOperationsException e) {
                System.out.println(e.getMessage() + " wybierz: " + calculator.availableOperations());
            } catch (Exception e) {
                System.out.println("błąd");
            }
        }
    }
}
