import calculator.Calculator;
import calculator.CantDivideByZeroException;
import calculator.UnsupportedPatternOpperationException;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome in the CALCULATOR!!");
        Calculator calculator = new Calculator();
        String result;

        while (true) {
            try {
                System.out.print("what to do(+ , - , * , / , exit, total): ");
                result = scanner.nextLine();
                if (result.equals("exit")) {
                    break;
                }
                if (result.equals("total")) {
                    System.out.println(calculator.getResult());
                    continue;
                }

                calculator.execute(result);

            } catch (UnsupportedPatternOpperationException e) {
                System.out.println("Operation dont match pattern");
            } catch (Exception e) {
                System.out.println("Incorrect operation");
            } catch (CantDivideByZeroException cantDivideByZero) {
                System.out.println("You cant divide by zero!");
            }

        }

    }
}