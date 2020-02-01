package calculator;


import java.util.regex.Pattern;

public class Calculator {
    double result;

    public void validateOperation(String command) throws UnsupportedPatternOpperation {
        Pattern pattern = Pattern.compile("[+\\-*/] \\d*\\.?\\d*");
        if (!pattern.matcher(command).matches()) {
            throw new UnsupportedPatternOpperation();
        }
    }

    public double execute(String command) throws UnsupportedPatternOpperation {
        validateOperation(command);
        String[] splittedString = command.split(" ");
        double numberFromSplitting = Double.parseDouble(splittedString[1]);

        switch (splittedString[0]) {
            case "+":
                result += numberFromSplitting;
                return result;
            case "-":
                result -= numberFromSplitting;
                return result;
            case "*":
                result *= numberFromSplitting;
                return result;
            case "/":
                result /= numberFromSplitting;
                return result;
            default:
                return 0;
        }

    }

    public double getResult() {
        return result;
    }
}
