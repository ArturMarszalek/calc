package calculator;

import java.util.HashMap;

public class Calculator {

    private double result;
    private HashMap<String, ICalculatorActionStrategy> strategies;

    public Calculator() {
        strategies = new HashMap<>();
        strategies.put("+", new AddStrategy());
        strategies.put("*", new MultipleStrategy());
        strategies.put("-", new SubtrackStrategy());
        strategies.put("/", new DiviStrategy());

        result = 0;
    }

    public double execute(String command) {

        String[] split = command.split(" ");
        String commandName = split[0];
        double number = Double.parseDouble(split[1]);

        result = strategies.get(commandName).calculate(result, number);
        return result;
    }

    public double getResult() {
        return result;
    }
}
