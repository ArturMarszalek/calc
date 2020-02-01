package calculator;


import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Calculator {
    double value = 0;

    public double execute(String command) throws Exception {

        Matcher matcher = getValidate(command);
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

    private Matcher getValidate(String command) throws UnsupportedCalculatorOperationsException {
      //  Pattern pattern = Pattern.compile("^[\\+,\\-,\\*,\\/] [\\d,.]+$"); <--- to zadziała jak używmy fond zamiast matches()
        Pattern pattern = Pattern.compile("[\\+,\\-,\\*,\\/] [\\d,.]+");
        Matcher matcher = pattern.matcher(command);

        if (!matcher.matches()) {
            throw new UnsupportedCalculatorOperationsException("Niepoprawne dane (UnsupportedCalculatonOperationsExecutions)");
        }
        return matcher;
    }
}
