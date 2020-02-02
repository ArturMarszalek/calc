import calculator.Calculator;
import calculator.UnsuportedActionException;
import calculator.UnsuportedCommandException;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        double startValue = 0;
        if (args.length > 0) {
            try {
                startValue = Double.parseDouble(args[0]);
            } catch (Exception e) {
                System.out.println("Nie poprawna wartość argumentu poczatkowego ");
            }
        }
        Calculator calculator = new Calculator();


        try {
            while (true) {
                System.out.println("Proszę podać działanie i liczbę ");
                Scanner sc = new Scanner(System.in);
                String command = sc.nextLine();
                if (command.equals("exit")) {
                    System.out.println("Wynik: " + calculator.getValue());
                    break;
                }
                if(command.equals("back")){

                    calculator.back();
                    for (Double d: calculator.getHistoricalValue()

                    ) {System.out.println("LOG: " +d);

                    }
                    break;

                }
                calculator.validation(command);
                System.out.println("Wynik: " + calculator.getValue());

                for (Double d: calculator.getHistoricalValue()

                ) {System.out.println("LOG: " +d);

                }

            }
        } catch (UnsuportedActionException e) {
            System.out.println("Nie poprawny format");
            System.out.println("Dotychczasowy rezultat to: " + calculator.getValue());
        } catch (UnsuportedCommandException e) {
            System.out.println("Nie obsługiwana operacja ");
        }




    }


}

