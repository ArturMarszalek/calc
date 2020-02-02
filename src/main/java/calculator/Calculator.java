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
        strategies.put("^", new ExponentiationStrategy());
    }

    public java.util.Set<String> getAvailableStringCalculator(){
        return strategies.keySet();
    }

    public double execute(String command) throws UnsupportedCalculatorOperationException, UnsupportedArithmeticOperationException {

        validCommand(command);

        String[] splitCommand = command.split(" ");
        String operator = splitCommand[0];
        double number = Double.parseDouble(splitCommand[1]);
        return result = strategies.getOrDefault(operator, new UnsupportedArithmeticStrategy()).calculate(result, number);

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
        // Pattern pattern = Pattern.compile("[\\^,\\!,\\+,\\-,*,\\/] \\d*.?\\d+$");
        Pattern pattern1 = Pattern.compile("(\\S+) \\d*\\.?\\d+");
        if (!pattern1.matcher(command).matches()) {
            throw new UnsupportedCalculatorOperationException();
        }
    }
}
