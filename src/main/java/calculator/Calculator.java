package calculator;


import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Calculator {

    private double result = 0;



    public double execute(String command) throws UnsupportedCalculatorOperationsException {

        validCommand(command);

        String[] splitResult = command.split(" ");

        Double value = Double.parseDouble(splitResult[1]);

        switch (splitResult[0]) {
            case "+":
                result += value;
                break;
            case "-":
                result -= value;
                break;
            case "*":
                result *= value;
                break;
            case "/":
                result /= value;
                break;
            default:
                System.out.println("Nie podbano stringa");
        }
        return result;
    }

    private void validCommand(String command) throws UnsupportedCalculatorOperationsException {
        Pattern pattern = Pattern.compile("[\\+\\-\\*\\/] [\\d,.]+");
        Matcher matcher = pattern.matcher(command);

        if (!matcher.matches()) {
            throw new UnsupportedCalculatorOperationsException("Niepoprawne dane");
        }
        String[] splittedCommand = matcher.group().split(" ");

    }

    public double getTotal() {
        return result;
    }
}
