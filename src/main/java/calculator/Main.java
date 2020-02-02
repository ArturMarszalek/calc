package calculator;


import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws Exception {

        System.out.println("Witaj w magicznym kalkulatorze!");
        double startValue = 0;
        if (args.length >= 1) {
            try {
                startValue = Double.parseDouble(args[0]);

            } catch (Exception e) {
                System.out.println("Argument powinien być liczbą");
                return;
            }
            for (String arg : args) {
                System.out.println("Początkowoa wartość została ustawiona na: " + startValue);
            }

        }
        System.out.println("Działanie: ");

        Calculator calculator = new Calculator(startValue);
        Scanner scanner = new Scanner(System.in);


        while (scanner.hasNext()) {
            try {
                String userChoice = scanner.nextLine();

                if (userChoice.equals("exit")) {
                    System.exit(0);
                } else if (userChoice.equals("total")) {
                    System.out.println("Aktyalny wynik: " + calculator.getTotal());

                } else if (userChoice.equals("back")) {

                    calculator.revertLast();
                    for (Double d : calculator.getLastValue()

                    ) {
                        System.out.println("Poprzedni wynik: " + d);

                    }
                    continue;
                } else {
                    double result = calculator.execute(userChoice);
                }

                System.out.println("Aktyalny wynik: " + calculator.getTotal());
                for (Double d : calculator.getLastValue()

                ) {

                    System.out.println("Poprzedni wynik: " + d);
                }
            } catch (UnsupportedCalculatorOperationsException | UnsupportedAritmeticOperationsException e) {
                System.out.println(e.getMessage() + " Wybierz operator: " + calculator.getAritmeticSymbols());
            } catch (Exception e) {
                System.out.println("Wpisaono niepoprawną komendę");
            }
        }
    }
}