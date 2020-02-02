package calculator;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        double startValue = 0;
        if (args.length >= 1){
            try {
                startValue = Double.parseDouble(args[0]);
            }catch (Exception e){
                System.out.println("Pierwszy argument nie jest liczbą");
                return;
            }

        }
        System.out.println("Wartość początkowa:" + startValue);


        Calculator calculator = new Calculator(startValue);
        Scanner scanner = new Scanner(System.in);

        System.out.println("Podaj działanie: ");



        while (true) {
            String userChoice = scanner.nextLine();


            try {
                System.out.println("Wynik działania " + calculator.execute(userChoice));

                if (userChoice.equals("total")) {
                    calculator.total();
                    continue;
                }

                if (userChoice.equals("exit")) {
                    break;
                }
            } catch (UnsupportedCalculatorOpperationException e) {
                System.out.println(e.getMessage() + " wybierz: " + calculator.getAvailableStringCalculator());
            } catch (Exception e) {
                System.out.println("błąd");

            }
        }
    }
}
