package calculator;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws UnsupportedCalculatorOperation {
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
            } catch (UnsupportedCalculatorOperation e) {
                System.out.println("Niepoprawna komenda, spróbuj \n" +
                        "[znak arytmetyczny][spacja][liczba]");
            }
//                } catch (Exception unsupportedCalculatorOperation){
//                System.out.println("Niepoprawna komenda");


        }
    }
}

