package calculator.operations;

import calculator.CantDivideByZeroException;

public class DivideNumber implements ICalcOperations {

    public void validateDividingByZero(Double numberFromSplitting) throws CantDivideByZeroException {
        if (numberFromSplitting == 0) {
            throw new CantDivideByZeroException();
        }
    }

    @Override
    public double calculate(double baseValue, double number) throws CantDivideByZeroException {
        validateDividingByZero(number);
        return baseValue/number;
    }
}
