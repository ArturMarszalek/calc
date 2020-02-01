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
                break;
            }
            try {
                System.out.println(calculator.execute(dzialanie));
            }catch (Exception e){
                System.out.println("Błąd! Nazwa nie poprawna.");
            }
        }
    }
}
