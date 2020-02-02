package calculator.operations;

import calculator.exceptions.CantDivideByZeroException;

public interface ICalcOperations {
    double calculate(double baseValue, double number) throws CantDivideByZeroException;
}
