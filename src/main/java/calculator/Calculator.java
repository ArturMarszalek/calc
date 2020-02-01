package calculator;


import java.util.regex.Pattern;

public class Calculator {


    double result = 0;

    public double execute(String command) throws UnsupportedCalculatorOpperationException {
//        boolean notMatch = false;
//        if (notMatch) {
//            throw (UnsupportedCalculatorOpperationException);

        validCommand(command);
//        }
        String[] tab = command.split(" ");

        switch (tab[0]) {
            case "+":
                result += Double.parseDouble(tab[1]);

                break;
            case "-":
                result -= Double.parseDouble(tab[1]);
                break;
            case "*":
                result *= Double.parseDouble(tab[1]);
                break;
            case "/":
                result /= Double.parseDouble(tab[1]);
                break;

        }

        return result;
    }

    public double total() {
        return result;
    }

    private void validCommand(String command) throws UnsupportedCalculatorOpperationException {
        Pattern pattern = Pattern.compile("[\\+\\-\\*\\/] \\d*\\.?\\d+");
        if (!pattern.matcher(command).matches()){
            throw new UnsupportedCalculatorOpperationException();
        }
    }
}
