package calculator;


import java.time.DayOfWeek;
import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Calculator {
    HashMap<String, CalculatorStrategy> strategies = new HashMap<>();
    double result;

    public Calculator() {
        strategies.put("+", new AddStrategy());
        strategies.put("-", new SubtractStrategy());
        strategies.put("*", new MultiplyStrategy());
        strategies.put("/", new DivideStrategy());
        strategies.put("^", new PowerStrategy());
    }

    public double execute(String command) throws UnsupportedCalculatorOperationsException {

        validCommand(command);

        String[] splitResult = command.split(" ");

        String aritmeticChar = splitResult[0];

        double value = Double.parseDouble(splitResult[1]);

        result =  strategies.get(aritmeticChar).calculate(result, value);
        return result;


    }

    private void validCommand(String command) throws UnsupportedCalculatorOperationsException {
        Pattern pattern = Pattern.compile("[+\\-*/^] [\\d,.]+");
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
