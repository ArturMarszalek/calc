package calculator.operations;

import calculator.exceptions.CantDivideByZeroException;
import calculator.exceptions.UnsupportedPatternOpperationException;

public interface ICalcOperations {
    double calculate(double baseValue, double number) throws CantDivideByZeroException, UnsupportedPatternOpperationException;
}
