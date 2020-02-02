package calculator;



import java.sql.SQLOutput;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        double  startValue = 0;
        if(args.length >= 1) {
            try {
                startValue = Double.parseDouble(args[0]);
            } catch (Exception e) {
                System.out.println("Pierwszy argument nie jest liczbą, żegnam :)");
                return;
            }
        }
        System.out.println("Poczatkowa wartosc: " + startValue);

            Scanner scanner = new Scanner(System.in);
            Calculator calculator = new Calculator();
            boolean shouldQuit = false;

            while (!shouldQuit) {
                System.out.print("Wprowadź działanie : ");

                try {
                    String operation = scanner.nextLine();
                    if (operation.equals("exit")) {
                        break;
                    }
                    System.out.println("\nWynik = " + calculator.execute(operation));
                } catch (UnsupportedArithmeticException e) {
                    System.out.println("zly operator" + calculator.getArithmeticSymbols());
                } catch (UnsupportedCalculatorOperationException e) {
                    System.out.println(e.getMessage());
                } catch (Exception e) {
                    System.out.println("błąd");
                }
            }
        }
    }















