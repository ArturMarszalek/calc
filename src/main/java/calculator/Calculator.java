package calculator;


import calculator.StrategyCalss.*;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Calculator {
    double value = 0;
    CalculationActionStrategy addStrategy = new Add();
    CalculationActionStrategy substract = new Substract();
    CalculationActionStrategy multiply = new Multiply();
    CalculationActionStrategy divide = new Divide();
    Map <String,CalculationActionStrategy> strategyMap = new HashMap<>();

    public double execute(String command) {
        addStrategyToMap();
        String[] calculation = command.split(" ");
        value = strategyMap.get(calculation[0]).calculate(value,Double.parseDouble(calculation[1]));

        return value;
    }

    public void validation(String commandToCheck) throws UnsuportedCommandException {
        Pattern pattern = Pattern.compile("[+,\\-,*,\\/] .?\\d+$");
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
    public void addStrategyToMap(){
        strategyMap.put("+",addStrategy);
        strategyMap.put("-",substract);
        strategyMap.put("*",multiply);
        strategyMap.put("/",divide);
    }

}
