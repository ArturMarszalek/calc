package calculator;


import strategy.*;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.regex.Pattern;

public class Calculator {

    HashMap<String, ICalculationActionStrategy> strategies = new HashMap<>();
    double result;
    private LinkedList<Object> list = new LinkedList<Object>();


    public Calculator(double startValue) {
        this();
        result = startValue;

    }
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

    public double getResult() {
        return result;
    }
    public void result(){

    }



    // LinkedList - do przodu & do tyłu - zrobić tak aby
//    public double redo () {
//
//    }

            Pattern pattern1 = Pattern.compile("(\\S+) \\d*\\.?\\d+");
            public void validCommand(String command) throws UnsupportedCalculatorOperationException {
                // Pattern pattern = Pattern.compile("[\\^,\\!,\\+,\\-,*,\\/] \\d*.?\\d+$");
                if (!pattern1.matcher(command).matches()) {
            throw new UnsupportedCalculatorOperationException();
        }
    }

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