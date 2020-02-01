package calculator;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {

        Calculator calculator = new Calculator();
        Scanner scanner = new Scanner(System.in);
        final String regex = "[\\+|\\-|\\*\\/] \\d*.?\\d";
        boolean exit = false;
        String op_n;

        System.out.print("Kalkulator \n\n");
        while(!exit) {
            System.out.print("\n+-*/ Liczba :");
            op_n = scanner.nextLine();

                if (op_n.equals("exit")) {
                    exit = true;
                } else if (op_n.matches(regex)) {
                    calculator.execute(op_n);
                } else { System.out.print( "Error \n" ); }
            System.out.print( calculator.value );
        }
    }
}
