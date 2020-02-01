package calculator;


import org.w3c.dom.ls.LSOutput;

import java.util.regex.Pattern;

public class Calculator {

    double result = 0;

    public double execute(String command) throws UnsupportedCalculatorOperation   {

        validCommand(command);

        String[] number = command.split(" ");

        switch (number[0]) {
            case "+":
                result += Double.parseDouble(number[1]);
                break;
            case "-":
                result -= Double.parseDouble(number[1]);
                break;
            case "*":
                result *=  Double.parseDouble(number[1]);
                break;
            case "/":
                result /= Double.parseDouble(number[1]);
                break;
            default:
                return result;
        }
        return result;
    }

    public double getTotal() {
        return result;
    }
    public void validCommand(String command) throws UnsupportedCalculatorOperation {
        Pattern pattern = Pattern.compile("[\\+,\\-,*,\\/] \\d*.?\\d+$");
        if (!pattern.matcher(command).matches()) {
            throw new UnsupportedCalculatorOperation();
        }
    }
}
