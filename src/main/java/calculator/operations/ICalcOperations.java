package calculator.operations;

import calculator.CantDivideByZeroException;

public interface ICalcOperations {
    double calculate(double baseValue, double number) throws CantDivideByZeroException;
}
