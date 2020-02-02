package calculator;

public class UnsupportedArithmeticOperationStrategy implements ICalculatorActionStrategy {
    @Override
    public double calculate(double baseValue, double number) throws UnsupportedArithmeticOperationException {
        throw new UnsupportedArithmeticOperationException();
    }
}