package calculator;

import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Calculator {

    double value = 0;
    HashMap<String, ICalculatorActionStrategy> strategies = new HashMap<>();

    public Calculator() {
        strategies.put("+", new AddStrategy());
        strategies.put("*", new MultiplyStrategy());
        strategies.put("-", new SubstractStrategy());
        strategies.put("/", new DivideStrategy());
    }

    public double execute(String command) throws UnsupportedCalculatorOperationsException {

        Matcher matcher = getValidate(command);
        String[] splittedCommand = matcher.group().split(" ");
        double number = Double.parseDouble(splittedCommand[1]);
        String operator = splittedCommand[0];
        value = strategies.get(operator).calculate(value, number);
        return value;
    }

    private Matcher getValidate(String command) throws UnsupportedCalculatorOperationsException {

        Pattern pattern = Pattern.compile("[\\+,\\-,\\*,\\/] [\\d,.]+");
        Matcher matcher = pattern.matcher(command);

        if (!matcher.matches()) {
            throw new UnsupportedCalculatorOperationsException("Niepoprawne dane");
        }
        return matcher;
    }
}