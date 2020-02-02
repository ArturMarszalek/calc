package calculator;

import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Calculator {

    double value = 0;
    HashMap<String, ICalculatorActionStrategy> strategies = new HashMap<>();

    public Calculator(double startvalue) {
this();
value = startvalue;
    }

    public Calculator() {
        strategies.put("+", new AddStrategy());
        strategies.put("*", new MultiplyStrategy());
        strategies.put("-", new SubstractStrategy());
        strategies.put("/", new DivideStrategy());
        strategies.put("^", new ExponentiationStrategy());
        strategies.put("#", new RootExtractionStrategy());
    }

    public double execute(String command) throws Exception {

        Matcher matcher = getValidate(command);
        String[] splittedCommand = matcher.group().split(" ");
        double number = Double.parseDouble(splittedCommand[1]);
        String operator = splittedCommand[0];
        value = strategies.getOrDefault(operator, new WrongInputStrategy()).calculate(value, number);
        return value;
    }

    private Matcher getValidate(String command) throws UnsupportedCalculatorOperationsException {

        Pattern pattern = Pattern.compile("(\\S+) \\d*\\.?\\d+"); // (\\S+) \\d*\\.?\\d+   /////////////////// .+ [\d,.]+
        Matcher matcher = pattern.matcher(command);

        if (!matcher.matches()) {
            throw new UnsupportedCalculatorOperationsException("Wpisz liczbę!");
        }
        return matcher;
    }

    public java.util.Set<String> availableOperations() {
        return strategies.keySet();
    }


}

