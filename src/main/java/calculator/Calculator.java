package calculator;
import calculator.StrategyCalss.*;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Calculator {

    public Calculator() {
        strategyMap.put("+", new Add());
        strategyMap.put("-", new Substract());
        strategyMap.put("*", new Multiply());
        strategyMap.put("/", new Divide());
        strategyMap.put("^",new PowerOfNumber());
    }

    double value = 0;

    Map<String, CalculationActionStrategy> strategyMap = new HashMap<>();

    public double execute(String command) {
        String[] calculation = command.split(" ");
        value = strategyMap.get(calculation[0]).calculate(value, Double.parseDouble(calculation[1]));
        return value;
    }

    public void validation(String commandToCheck) throws UnsuportedCommandException {
        Pattern pattern = Pattern.compile("[+,\\-,*,\\/,^] \\d?.+$");
        Matcher matcher = pattern.matcher(commandToCheck);
        if (!matcher.matches())
            throw new UnsuportedCommandException();
        else {
            execute(commandToCheck);
        }
    }

    public double getValue() {
        return value;
    }


}
