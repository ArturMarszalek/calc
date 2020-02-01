package calculator;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Suma: ");
            String dzialanie = scanner.nextLine();
            if (dzialanie.equals("exit")) {
                break;
            }
            if (dzialanie.equals("total")){
                calculator.total();
            }
            try {
                System.out.println(calculator.execute(dzialanie));
            }catch (Exception e){
                System.out.println("Błąd. Coś poszło nie tak");
            }
        }
    }
}