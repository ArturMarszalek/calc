package calculator;

import strategy.RootStrategy;

import java.util.HashMap;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws UnsupportedCalculatorOperationException {
        Calculator calculator = new Calculator();
        Scanner scanner = new Scanner(System.in);

        while (true){
            System.out.println("Podaj komendę(dodawanie, odejmowanie, dzielenie, mnożenie, total, exit): ");
            String userChoice = scanner.nextLine();

            if (userChoice.equals("exit")){
                System.out.println("Program zakończył działanie");
                break;
            } else if (userChoice.equals("total")){
                System.out.println("Wynikiem działań jest: " + calculator.getTotal());
                continue;
            }
            try {
                System.out.println("Wynikiem działania jest: " + calculator.execute(userChoice));
            } catch (UnsupportedArithmeticOperationException e) {
                System.out.println("Podałeś zły znak działania, spróbuj jedną z następujących" + calculator.getAvailableStringCalculator());
            } catch (UnsupportedCalculatorOperationException e) {
                System.out.println("Niepoprawna komenda, spróbuj \n" +
                        calculator.getAvailableStringCalculator() + "[spacja][liczba]");
            }
        }
    }
}

