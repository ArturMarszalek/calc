package calculator;

import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        for (String arg:args){
            System.out.println(arg);
        }

        Scanner scanner = new Scanner(System.in);
        Calculator calculator = new Calculator();
        calculator.setValue(Double.parseDouble(args[0]));
        boolean shouldQuit=false;

        while (!shouldQuit) {
            System.out.print("Wprowadź działanie : ");

            try {
                String operation = scanner.nextLine();
                if (operation.equals("exit")) {
                    break;
                }
                System.out.println("\nWynik = "+calculator.execute(operation));
            } catch (UnsupportedArtimeticOperationletters e) {
                System.out.println("Błędny znak! użyj "+calculator.getAritmeticSymbols());
            } catch (UnsupportedCalculatorOperationsException e) {
                System.out.println("błędne dane");
            } catch (Exception e) {
                System.out.println("błędna wartość");
            }
        }
    }
}
