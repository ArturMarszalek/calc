package calculator;


import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Calculator {
    double value = 0;

    public double getValue() {
        return value;
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

    public void validation(String commandToCheck) throws UnsuportedCommandException {
        Pattern pattern = Pattern.compile("[+,\\-,*,\\/] .?\\d+$");
        Matcher matcher = pattern.matcher(commandToCheck);
        if (!matcher.matches())
            throw new UnsuportedCommandException();
        else {
            execute(commandToCheck);
        }
    }
}
