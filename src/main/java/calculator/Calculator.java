package calculator;


import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Calculator {
    private double value = 0;


    public double execute(String command) throws Exception {
        getValidate(command);

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

    public double getResult() {
        return value;

    }
    private Matcher getValidate(String command) throws UnsupportedCalculatorOperationException {

        Pattern pattern = Pattern.compile("[\\+,\\-,\\*,\\/] [\\d,.]+");
        Matcher matcher = pattern.matcher(command);

        if (!matcher.matches()) {
            throw new UnsupportedCalculatorOperationException("Wyjatek! (UnsupportedCalculatonOperationsExecutions)");
        }
        return matcher;
    }
}
