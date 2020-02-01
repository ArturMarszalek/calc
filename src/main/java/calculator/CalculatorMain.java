package calculator;

import java.util.Scanner;

public class CalculatorMain {
    public static void main(String[] args) {
Calculator calculator = new Calculator();
        Scanner scanner=new Scanner(System.in);
        boolean loop = true;
        while (loop) {
            System.out.println("Działanie: ");
            String dzialanie = scanner.nextLine();
if (dzialanie.equals("exit")){
    loop=false;
}
            System.out.println(calculator.execute(dzialanie));
        }
    }
}
