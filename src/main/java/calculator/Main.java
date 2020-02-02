package calculator;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        double startValue = 0;
        if (args.length >= 1) {
            try {
                startValue = Double.parseDouble(args[0]);
            } catch (Exception e) {
                System.out.println("Pierwszy argument nie jest liczbą");
                return;
            }
        }

        System.out.println("Początkowa wartość: " + startValue);

        Calculator calculator = new Calculator(startValue);
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Podaj komendę(dodawanie, odejmowanie, dzielenie, mnożenie, potegowanie, pierwiastkowanie, total, exit): ");
            String userChoice = scanner.nextLine();

            if (userChoice.equals("exit")) {
                System.out.println("Program zakończył działanie");
                break;
            } else if (userChoice.equals("total")) {
                System.out.println("Wynikiem działań jest: " + calculator.getResult());
                continue;
            }
            try {
                System.out.println("Wynikiem działania jest: " + calculator.execute(userChoice));
            } catch (UnsupportedPatternOpperation e) {
                System.out.println("Niepoprawna komenda, spróbuj \n" +
                        "[znak arytmetyczny][spacja][liczba]");
            } catch (UnsupportedArithmeticOperationException e) {
                System.out.println("Dzień dobry, podałeś zły znak działania");
            } catch (Exception e) {
                System.out.println("błąd");
            }
        }
    }
}