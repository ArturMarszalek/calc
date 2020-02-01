package calculator;


import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Calculator {
    private double value = 0;


    public double execute(String action) throws UnsupportedCommandException {

    validCommand(action);

        String[] items = action.split(" ");
        if (items.length < 2) {
            return value;
        }
        String aritmeticChar = items[0];
        double numer = Double.parseDouble(items[1]);


        switch (aritmeticChar) {
            case "+":
                return value = addNumber(numer);
            case "-":
                return value = substractNumber(numer);
            case "*":
                return value = multiplyNumbers(numer);

            case "/":
                return value = divideNumbers(numer);
            default:

                return 0;

        }

    }

    private void validCommand(String action) throws UnsupportedCommandException {
        Pattern p = Pattern.compile("[\\+|\\-|\\*|\\/] d*.?d+$");
        Matcher m = p.matcher(action);
        Pattern emial=Pattern.compile("\\[a-z]|[0-9]@\\com|pl$");
        boolean matches = m.matches();
        if(!matches) {
            throw new UnsupportedCommandException();
        }
    }

    public double addNumber(double number) {
        return value += number;
    }

    public double substractNumber(double number) {
        return value - number;
    }

    public double multiplyNumbers(double number) {
        return value * number;
    }

    public double divideNumbers(double number) {
        return value / number;
    }

    public double total() {
        return value;
    }


//    public double execute(String command) {
//        return 0;
//    }
}
