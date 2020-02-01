package calculator;


import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Calculator {

    private double result;

    public Calculator() {
        result = 0;
    }

    public double execute(String command) throws UnsupportedCommandException {

        Pattern p = Pattern.compile("^[\\+\\-\\*\\/] \\d*\\.?\\d+$");

        Matcher m = p.matcher(command);

        if (!m.find()) {
            throw new UnsupportedCommandException("Niepoprawna komenda!");
        }

        String[] split = m.group().split(" ");

        double value = Double.parseDouble(split[1]);

        switch (split[0]) {

            case "+":
                result += value;
                return result;

            case "-":
                result -= value;
                return result;

            case "*":
                result *= value;
                return result;

            case "/":
                result /= value;
                return result;

            default:
                throw new UnsupportedCommandException("Nie podano operatora!");

        }
    }

    public double getResult() {
        return result;
    }
}
