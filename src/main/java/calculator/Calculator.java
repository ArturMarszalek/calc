package calculator;

import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Calculator {

    private double result;
    private HashMap<String, ICalculatorActionStrategy> strategies;

    public Calculator(double value) {
        strategies = new HashMap<>();
        strategies.put("+", new AddStrategy());
        strategies.put("*", new MultipleStrategy());
        strategies.put("-", new SubtrackStrategy());
        strategies.put("/", new DiviStrategy());
        strategies.put("^", new PowStrategy());
        strategies.put("√", new SqrtStrategy());

        result = value;
    }

    public Calculator() {
        this(0);
    }

    public double execute(String command) throws UnsupportedActionException, UnsupportedStrategyException {

        Pattern p = Pattern.compile("^(\\S+) \\d*\\.?\\d+$");
        Matcher m = p.matcher(command);

        String[] split = command.split(" ");

        if (split.length == 1) {
            throw new UnsupportedActionException("Niewłaściwa akcja!");
        }

        String commandName = split[0];
        double number = Double.parseDouble(split[1]);

        ICalculatorActionStrategy strategy = strategies.getOrDefault(commandName, new DefaultStrategy());

        result = strategy.calculate(result, number);
        return result;
    }

    public double getResult() {
        return result;
    }
}
