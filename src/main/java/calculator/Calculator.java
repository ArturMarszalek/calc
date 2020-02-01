package calculator;


import java.util.Scanner;

public class Calculator {
   private double value = 0;

    public double execute(String command) {


        String[] splittedCommand = command.split(" ");

        String operator = splittedCommand[0];
        String number = splittedCommand[1];

        switch (operator) {
            case "+":
                value += Double.parseDouble(number);
                break;
            case "-":
                value -= Double.parseDouble(number);
                break;
            case "*":
                value *= Double.parseDouble(number);
                break;
            case "/":
                value /= Double.parseDouble(number);
                break;
        }
        return value;
    }
}
