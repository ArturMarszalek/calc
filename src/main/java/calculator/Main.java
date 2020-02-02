package calculator;

import java.util.Scanner;

public class Main {
    public static void main(String[] args){

        Scanner scanner = new Scanner(System.in);

        double startValue ;
        if (args.length>=1){ startValue = Double.parseDouble(args[0]);} else {startValue=0;}
        Calculator calculator = new Calculator(startValue);
        boolean shouldQuit=false;

        while (!shouldQuit) {
            System.out.print("Wprowadź działanie : ");

            try {
                String operation = scanner.nextLine();
                if (operation.equals("exit")) {
                    break;
                }
                if (operation.equals("redo")){
                    calculator.redo();
                }
                else if (operation.equals("back")){
                    calculator.back();
                }

                else{
                System.out.println("\nWynik = "+calculator.execute(operation));}
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
