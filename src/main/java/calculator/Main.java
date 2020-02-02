package calculator;

import calculator.Calculator;
import calculator.exceptions.*;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        double startValue = 0;

        try {
            startValue = Double.parseDouble(args[0]);
        } catch (Exception e) {
            System.out.println("Invalid starting parameter");
            return;
        }

        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome in the CALCULATOR!!");
        Calculator calculator = new Calculator(startValue);

        String result;

        while (true) {
            try {
                System.out.println("Available operations: " + calculator.operationsHashMap.keySet() + " exit, total, undo, redo:");
                result = scanner.nextLine();
                if (result.equals("exit")) {
                    break;
                }
                if (result.equals("total")) {
                    System.out.println(calculator.getResult());
                    continue;
                }
                if (result.equals("back")){
                    calculator.back();
                    continue;
                }if (result.equals("undo")){
                    calculator.undo();
                    continue;
                }if (result.equals("redo")){
                    calculator.redo();
                    continue;
                }



                calculator.execute(result);

            } catch (UnsupportedStrategyOperationException e) {
                System.out.println("Incorrect writing schematic");
            } catch (UnsupportedPatternOpperationException e) {
                System.out.println("Incorrect operration");
            } catch (CantRedoFurtherException e) {
                System.out.println("You can't redo further");
            }catch (CantUndoFurtherException e) {
                System.out.println("You can't undo further");
            } catch (CantDivideByZeroException cantDivideByZero) {
                System.out.println("You cant divide by zero!");
            } catch (Exception e) {
                System.out.println("Other error");
            }

        }

    }
}
