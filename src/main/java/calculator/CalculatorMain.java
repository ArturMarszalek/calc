package calculator;

import java.util.Scanner;

public class CalculatorMain {
    public static void main(String[] args) {


        Calculator calculator = new Calculator();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Działanie: ");
            String dzialanie = scanner.nextLine();
            if (dzialanie.equals("exit")) {
                break;
            }
            if (dzialanie.equals("total")){
                calculator.total();
            }
            try {
                System.out.println(calculator.execute(dzialanie));
            }catch (UnsupportedCommandException e){
                System.out.println("Błąd! walidacja nie poprawna.");
            }catch (Exception e){
                System.out.println("Błąd! ");
            }
        }
    }
}
