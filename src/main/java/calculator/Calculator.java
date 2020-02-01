package calculator;


import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Calculator {
    double value = 0;

    public double execute(String command) throws Exception {

        Pattern pattern = Pattern.compile("[\\+,\\-,\\*,\\/] [\\d,.]+");
        Matcher matcher = pattern.matcher(command);

        if (!matcher.find()) {
            throw new UnsupportedCalculatorOperationsException("Niepoprawne dane (UnsupportedCalculatonOperationsExecutions)");
        }
        String[] splittedCommand = matcher.group().split(" ");

        String operator = splittedCommand[0];
        String number = splittedCommand[1];

        switch (operator) {
            case "+":
                value += Double.parseDouble(number);
                return value;
            case "-":
                value -= Double.parseDouble(number);
                return value;
            case "*":
                value *= Double.parseDouble(number);
                return value;
            case "/":
                value /= Double.parseDouble(number);
                return value;
        }
        return 0;

    }
}
