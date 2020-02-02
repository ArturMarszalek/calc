package calculator.operations;

import calculator.exceptions.CantDivideByZeroException;
import calculator.exceptions.UnsupportedPatternOpperationException;

public class defaultStrategy implements ICalcOperations {
    @Override
    public double calculate(double baseValue, double number) throws  UnsupportedPatternOpperationException {
       throw new UnsupportedPatternOpperationException();
    }
}
