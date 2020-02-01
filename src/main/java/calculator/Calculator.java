package calculator;


import java.util.Arrays;
import java.util.List;

public class Calculator {
    private double value = 0;

    public double execute(String action) {
        String[] items = action.split(" ");

        String aritmeticChar = items[0];
        double numer = Double.parseDouble(items[1]);

        switch (aritmeticChar) {
            case "+":
                return addNumber(numer);
            case "-":
             return   substractNumber(numer);
            case "*":
               return multiplyNumbers(numer);

            case "/":
               return divideNumbers(numer);

            default:
               return 0;

        }
    }

    public double addNumber(double number) {
        return value += number;
    }

    public double substractNumber(double number) {
        return value-number;
    }

    public double multiplyNumbers(double number) {
        return value*number;
    }

    public double divideNumbers(double number) {
        return value/number;
    }


//    public double execute(String command) {
//        return 0;
//    }
}
