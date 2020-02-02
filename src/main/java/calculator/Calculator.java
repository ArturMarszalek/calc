package calculator;


import calculator.exceptions.CantDivideByZeroException;
import calculator.exceptions.UnsupportedPatternOpperationException;
import calculator.exceptions.UnsupportedStrategyOperationException;
import calculator.operations.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Stack;
import java.util.regex.Pattern;

public class Calculator {
    double result;
    HashMap<String, ICalcOperations> operationsHashMap = new HashMap<>();
    Stack<Double> operationList = new Stack<>();
    ArrayList<Double> historicalValue = new ArrayList<>();
    int historicalValueIndex;

    public Calculator(double startValue) {
        result = startValue;
        historicalValue.add(startValue);
        operationsHashMap.put("+", new AddNumber());
        operationsHashMap.put("-", new SubtractNumber());
        operationsHashMap.put("*", new MultiplyNumber());
        operationsHashMap.put("/", new DivideNumber());
        operationsHashMap.put("sqrt", new SqrtNumber());
        operationsHashMap.put("^", new PowerNumbers());

    }

    public Calculator() {
        result = 0;
        historicalValue.add(0.0);
        operationsHashMap.put("+", new AddNumber());
        operationsHashMap.put("-", new SubtractNumber());
        operationsHashMap.put("*", new MultiplyNumber());
        operationsHashMap.put("/", new DivideNumber());
        operationsHashMap.put("sqrt", new SqrtNumber());
        operationsHashMap.put("^", new PowerNumbers());

    }

    public double execute(String command) throws UnsupportedPatternOpperationException, CantDivideByZeroException, UnsupportedStrategyOperationException {
        /* validateWrongOperation(command);
        validateOperation(command);*/
        String[] splittedString = command.split(" ");
        double numberFromSplitting = Double.parseDouble(splittedString[1]);
        //      result = operationsHashMap.get(splittedString[0]).calculate(result, numberFromSplitting);
        //operacje defaultowe
        operationList.push(result);
        result = operationsHashMap.getOrDefault(splittedString[0], new defaultStrategy()).calculate(result, numberFromSplitting);
        historicalValue.add(result);
        historicalValueIndex=historicalValue.size()-1;
        return result;
    }

    public void undo() {

        historicalValueIndex--;
        result = historicalValue.get(historicalValueIndex);
    }
    public void redo(){

        historicalValueIndex++;
        result = historicalValue.get(historicalValueIndex);
    }

    public void back() {

        result = operationList.pop();

    }

    public double getResult() {
        return result;
    }

    public void validateOperation(String command) throws UnsupportedPatternOpperationException {
        Pattern pattern = Pattern.compile("([+\\-*/^]|(sqrt)){1} \\d*\\.?\\d*");

        if (!pattern.matcher(command).matches()) {
            throw new UnsupportedPatternOpperationException();
        }
    }

    public void validateWrongOperation(String command) throws UnsupportedStrategyOperationException {
        Pattern pattern = Pattern.compile("(\\S+) \\d*\\.?\\d*");

        if (!pattern.matcher(command).matches()) {
            throw new UnsupportedStrategyOperationException();
        }
    }

}
