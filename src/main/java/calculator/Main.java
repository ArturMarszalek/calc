package calculator;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Calculator calculator = new Calculator();
        System.out.println("Witaj w kalkulatorze");
        String result;

        while (true) {
            try {
                System.out.println("Co zrobic: ");
                result = scanner.nextLine();
                if (result.equals("exit")){
                    break;
                }
                if (result.equals("total")) {
                    calculator.total();
                    continue;
                }
                calculator.execute(result);
            } catch (Exception e) {
                System.out.println("Nie poprawna operacja");
            }
        }
    }
}

