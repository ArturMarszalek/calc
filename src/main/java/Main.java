import calculator.Calculator;

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
                    calculator.total();
                    continue;
                }
                calculator.execute(result);
            } catch (Exception e) {
                System.out.println("Incorrect operation");
            }

        }

    }
}
