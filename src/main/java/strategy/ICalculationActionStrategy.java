package strategy;

import calculator.UnsupportedArithmeticOperationException;

public interface ICalculationActionStrategy {
    public double calculate(double baseValue, double number) throws UnsupportedArithmeticOperationException;
}
