package calculator;


import java.util.Scanner;
import java.util.regex.Pattern;

public class Calculator {
    double value = 0;

    public void inputDate() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Proszę podać działanie i liczbę ");
        String command = sc.nextLine();
        double value = execute(command);
        System.out.println(value);
        if (command.equals("exit")) {
            System.out.println("Rezultat to : " + value);
        }
        else {
            inputDate();
        }
    }


    public double execute(String command) {

        String[] calculation = command.split(" ");
        switch (calculation[0]) {
            case "+":
                value += Double.parseDouble(calculation[1]);
                break;
            case "-":
                value -= Double.parseDouble(calculation[1]);
                break;
            case "*":
                value *= Double.parseDouble(calculation[1]);
                break;
            case "/":
                value /= Double.parseDouble(calculation[1]);
                break;
        }


        return value;
    }
}
