package calculator;

import calculator.StrategyCalss.*;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Calculator {

    private UnsupportedOperationStrategy defaultStrategy;
    private List<Double> historicalValue = new ArrayList<>();
    public int indexOfHistoricalValue = -1;


    public Calculator(double args) {
        this.value = args;
        strategyMap.put("+", new Add());
        strategyMap.put("-", new Substract());
        strategyMap.put("*", new Multiply());
        strategyMap.put("/", new Divide());
        strategyMap.put("^", new PowerOfNumber());
        strategyMap.put("'", new Roots());

    }

    public Calculator() {
        this(0);
    }

    double value;

    Map<String, CalculationActionStrategy> strategyMap = new HashMap<>();

    public double execute(String command) throws UnsuportedActionException, UnsuportedCommandException {
        historicalValue.add(value);
        indexOfHistoricalValue++;
        String[] calculation = command.split(" ");
        defaultStrategy = new UnsupportedOperationStrategy();
        CalculationActionStrategy chosenStrategy = strategyMap.getOrDefault(calculation[0], defaultStrategy);
        value = chosenStrategy.calculate(value, Double.parseDouble(calculation[1]));
        return value;
    }

    public void back() {

        value = historicalValue.get(indexOfHistoricalValue);
        indexOfHistoricalValue--;

    }

    public void redo() {
        indexOfHistoricalValue++;
        value = historicalValue.get(indexOfHistoricalValue);

    }

    public void validation(String commandToCheck) throws UnsuportedActionException, UnsuportedCommandException {
        Pattern pattern = Pattern.compile("(\\S+) \\d*\\.?\\d+");
        Matcher matcher = pattern.matcher(commandToCheck);
        if (!matcher.matches())
            throw new UnsuportedActionException();
        else {
            execute(commandToCheck);
        }

    }

    public double getValue() {
        return value;
    }


}
