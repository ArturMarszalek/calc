package calculator.operations;

import calculator.exceptions.CantDivideByZeroException;

public class SqrtNumber implements ICalcOperations {
    @Override
    public double calculate(double baseValue, double number) throws CantDivideByZeroException {
        return Math.sqrt(number);
    }
}
