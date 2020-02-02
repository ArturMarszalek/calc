package calculator;


import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws Exception {

        System.out.println("Witaj w magicznym kalkulatorze!");
        double startValue = 0;
        if (args.length >= 1) {
            try {
                startValue = Double.parseDouble(args[0]);

            } catch (Exception e){
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
                    System.out.println(calculator.getTotal());
                } else {
                    double result = calculator.execute(userChoice);
                }
            } catch (UnsupportedCalculatorOperationsException | UnsupportedAritmeticOperationsException e) {
                System.out.println(e.getMessage() + " Wybierz operator: " + calculator.getAritmeticSymbols());
            } catch (Exception e) {
                System.out.println("Wpisaono niepoprawną komendę");
            }
        }
    }
}