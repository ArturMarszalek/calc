package strategy;

import calculator.UnsupportedArithmeticOperationException;

public class UnsupportedArithmeticStrategy implements ICalculationActionStrategy {
    @Override
    public double calculate(double baseValue, double number) throws UnsupportedArithmeticOperationException {
        throw new UnsupportedArithmeticOperationException();
    }
}
