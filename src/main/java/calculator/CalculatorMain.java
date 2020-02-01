package calculator;

import java.util.Scanner;

public class CalculatorMain {
    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        Scanner scanner = new Scanner(System.in);
        boolean loop = true;
        while (loop) {
            System.out.println("Działanie: ");
            String dzialanie = scanner.nextLine();
            if (dzialanie.equals("exit")) {
                loop = false;
            }
            try {
                System.out.println(calculator.execute(dzialanie));
            }catch (ArrayIndexOutOfBoundsException e){
                System.out.println("Nazwa nie poprawna");
            }
        }
    }
}
