package calculator;


import strategy.*;

import java.util.HashMap;
import java.util.regex.Pattern;

public class Calculator {

    HashMap<String, ICalculationActionStrategy> strategies = new HashMap<>();
    double result;

    public Calculator() {
        strategies.put("+", new AddStrategy());
        strategies.put("-", new SubstractStrategy());
        strategies.put("*", new MultiplyStrategy());
        strategies.put("/", new DivideStrategy());
        strategies.put("!", new RootStrategy());
    }

    public double execute(String command) throws UnsupportedCalculatorOperationException {

        validCommand(command);

        String[] splitCommand = command.split(" ");
        String arithmeticChar = splitCommand[0];
        double number = Double.parseDouble(splitCommand[1]);
        return result = strategies.get(arithmeticChar).calculate(result, number);

    }
        // METODA ROBIENIA SWITCH / CASE

//        public double execute(String command) throws UnsupportedCalculatorOperationException {
//
//            validCommand(command);
//            String[] number = command.split(" ");


//        switch (number[0]) {
//            case "+":
//                 result = addStrategy.calculate(result, Double.parseDouble(number[1]));
//                break;
//            case "-":
//                result -= Double.parseDouble(number[1]);
//                break;
//            case "*":
//                result *=  Double.parseDouble(number[1]);
//                break;
//            case "/":
//                result /= Double.parseDouble(number[1]);
//                break;
//            default:
//                return result;
//        }
//        return result;
//    }

    public double getTotal() {
        return result;
    }
    public void validCommand(String command) throws UnsupportedCalculatorOperationException {
        Pattern pattern = Pattern.compile("[\\!,\\+,\\-,*,\\/] \\d*.?\\d+$");
        if (!pattern.matcher(command).matches()) {
            throw new UnsupportedCalculatorOperationException();
        }
    }
}
