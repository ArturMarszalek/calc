package calculator.operations;

import calculator.exceptions.CantDivideByZeroException;

public class PowerNumbers implements ICalcOperations {
    @Override
    public double calculate(double baseValue, double number) throws CantDivideByZeroException {
        return Math.pow(baseValue,number);
    }
}
