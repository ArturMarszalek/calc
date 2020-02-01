package calculator;

import java.util.regex.Pattern;

public class Calculator {

    double wynik = 0;

    public double execute(String command) throws UnsupportedCalculatorOperationException {

        validCommand(command);

        String[] split = command.split(" ");

        switch (split[0]) {
            case "+":
                wynik += Double.parseDouble(split[1]);
                break;

            case "-":
                wynik -= Double.parseDouble(split[1]);
                break;

            case "*":
                wynik *= Double.parseDouble(split[1]);
                break;

            case "/":
                wynik /= Double.parseDouble(split[1]);
                break;

        }

        return wynik;

    }

    public double total(){
        return wynik;

    }

    public void validCommand(String command) throws UnsupportedCalculatorOperationException {
        Pattern pattern = Pattern.compile("[\\+,\\-,*,\\/] \\d*.?\\d+$");
        if (!pattern.matcher(command).matches()) {
            throw new UnsupportedCalculatorOperationException();
        }
    }
}