package calculator;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

//        for (String arg : args) {
//            System.out.println(arg);
//        }
        double startValue = 0;
        if (args.length >= 1) {
            try {
                startValue = Double.parseDouble(args[0]);
            } catch (Exception e) {
                System.out.println("Pierwszy argument nie jest liczbą");
                return;
            }
        }

        System.out.println("początkowa wartość: " + startValue);

        Scanner scanner = new Scanner(System.in);
        Calculator calculator = new Calculator(startValue);

        boolean shouldQuit = false;

        while (!shouldQuit) {
            System.out.print("Wprowadź działanie : ");

            try {
                String operation = scanner.nextLine();
                if (operation.equals("exit")) {
                    break;
                }
                if (operation.equals("back")) {
                    calculator.back();
                } else {
                    System.out.println("\nWynik = " + calculator.execute(operation));
                }
            } catch (UnsupportedCalculatorOperationsException e) {
                System.out.println(e.getMessage() + " wybierz: " + calculator.availableOperations());
            } catch (Exception e) {
                System.out.println("błąd");
            }
        }
    }
}
