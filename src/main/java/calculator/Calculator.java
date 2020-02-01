package calculator;


import calculator.strategy.*;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Calculator {
    Map<String, ICalculatorStrategy> strategies = new HashMap<>();

    double value = 0;

    public Calculator() {
        strategies.put("+", new AddStrategy());
        strategies.put("-", new SubtractionStrategy());
        strategies.put("*", new MultiplyStrategy());
        strategies.put("/", new DivisionStrategy());
    }

    public double execute(String command) throws Exception {

        Matcher matcher = getValidate(command);
        String[] splittedCommand = matcher.group().split(" ");

        ICalculatorStrategy addStrategy = new AddStrategy(); //+++++
        ICalculatorStrategy subtractionStrategy = new SubtractionStrategy(); //-----
        ICalculatorStrategy multiplyStrategy = new MultiplyStrategy(); //******
        ICalculatorStrategy divisionStrategy = new DivisionStrategy(); ///////


        String operator = splittedCommand[0];
        String number = splittedCommand[1];

        value = strategies.get(operator).calculate(value, Double.parseDouble(number));
        return value;

//        switch (operator) {
//            case "+":
////                value += Double.parseDouble(number);
//                value += addStrategy.calculate(value,Double.parseDouble(number));
//                return value;
//            case "-":
//                value += subtractionStrategy.calculate(value,Double.parseDouble(number));
//                return value;
//            case "*":
//                value = multiplyStrategy.calculate(value,Double.parseDouble(number));
//                return value;
//            case "/":
//                value = divisionStrategy.calculate(value,Double.parseDouble(number));
//                return value;
//        }
//        return 0;

    }

    private Matcher getValidate(String command) throws UnsupportedCalculatorOperationsException {
        //  Pattern pattern = Pattern.compile("^[\\+,\\-,\\*,\\/] [\\d,.]+$"); <--- to zadziała jak używmy fond zamiast matches()
        Pattern pattern = Pattern.compile("[\\+,\\-,\\*,\\/] [\\d,.]+");
        Matcher matcher = pattern.matcher(command);

        if (!matcher.matches()) {
            throw new UnsupportedCalculatorOperationsException("Niepoprawne dane (UnsupportedCalculatonOperationsExecutions)");
        }
        return matcher;
    }
}

//my email validation ([\w]+[.]?)+([\w])@([\w]+[.]?)+([\w])