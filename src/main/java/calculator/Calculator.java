package calculator;


import calculator.exceptions.CantDivideByZeroException;
import calculator.exceptions.UnsupportedPatternOpperationException;
import calculator.exceptions.UnsupportedStrategyOperationException;
import calculator.operations.*;

import java.util.HashMap;
import java.util.regex.Pattern;

public class Calculator {
    double result;

    public void validateOperation(String command) throws UnsupportedPatternOpperationException {
        Pattern pattern = Pattern.compile("([+\\-*/\\^]|(sqrt)){1} \\d*\\.?\\d*");

        if (!pattern.matcher(command).matches()) {
            throw new UnsupportedPatternOpperationException();
        }
    }
    public void validateWrongOperation(String command) throws UnsupportedStrategyOperationException {
        Pattern pattern = Pattern.compile(".+ \\d*\\.?\\d*");

        if (!pattern.matcher(command).matches()){
            throw new UnsupportedStrategyOperationException();
        }
    }


    public double execute(String command) throws UnsupportedPatternOpperationException, CantDivideByZeroException {
        validateOperation(command);
        String[] splittedString = command.split(" ");
        double numberFromSplitting = Double.parseDouble(splittedString[1]);
        HashMap<String, ICalcOperations> operationsHashMap = new HashMap<>();

        operationsHashMap.put("+", new AddNumber());
        operationsHashMap.put("-", new SubtractNumber());
        operationsHashMap.put("*", new MultiplyNumber());
        operationsHashMap.put("/", new DivideNumber());
        operationsHashMap.put("sqrt", new SqrtNumber());
        operationsHashMap.put("^", new PowerNumbers());

        result = operationsHashMap.get(splittedString[0]).calculate(result, numberFromSplitting);
        return result;

    }

    public double getResult() {
        return result;
    }
}
