package calculator;

import strategy.RootStrategy;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Scanner;

public class Main {


    public static void main(String[] args) throws UnsupportedCalculatorOperationException {

        double startValue = 0;
        if (args.length >= 1) {
            try {
                startValue = Double.parseDouble(args[0]);
            } catch (Exception e) {
                System.out.println("Podana wartość nie jest liczbą");
                return;
            }
            System.out.println("Początkowa wartość: " + startValue);
        }

        Calculator calculator = new Calculator(startValue);
        Scanner scanner = new Scanner(System.in);
        LinkedList<Double> listOfResults = new LinkedList<Double>();

        while (true){
            System.out.println("Podaj komendę(dodawanie, odejmowanie, dzielenie, mnożenie, total, exit, back, redo): ");
            String userChoice = scanner.nextLine();

            if (userChoice.equals("exit")){
                System.out.println("Program zakończył działanie");
                break;
            } else if (userChoice.equals("total")){
                System.out.println("Wynikiem działań jest: " + calculator.getResult());
                continue;
            } else if (userChoice.equals("back")){
                listOfResults.removeLast();
                System.out.println("Wynikiem działania po powrocie jest: " + listOfResults.getLast());
                continue;
            } else if (userChoice.equals("rozmiar stacka")){
                System.out.println("Rozmiar stacka: " + listOfResults.size());
                continue;
            }
            try {
                System.out.println("Wynikiem działania jest: " + calculator.execute(userChoice));
                listOfResults.addLast(calculator.getResult());
            } catch (UnsupportedArithmeticOperationException e) {
                System.out.println("Podałeś zły znak działania, spróbuj jedną z następujących" + calculator.getAvailableStringCalculator());
            } catch (UnsupportedCalculatorOperationException e) {
                System.out.println("Niepoprawna komenda, spróbuj \n" +
                        calculator.getAvailableStringCalculator() + "[spacja][liczba]");
            }

        }
    }
}

