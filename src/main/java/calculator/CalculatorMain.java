package calculator;

import java.util.Scanner;

public class CalculatorMain {
    public static void main(String[] args) {
Calculator calculator = new Calculator();
        Scanner scanner=new Scanner(System.in);
        System.out.println("Działanie: ");
        String dzialanie = "+ 4";
        System.out.println( calculator.execute(dzialanie));
    }
}
