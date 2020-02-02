package calculator;

public class UnsupportedArithmeticOperationStrategy implements ICalculateActionStrategy {
    @Override
    public double calculate(double baseValue, double number) throws  UnsupportedArithmeticOperationException {
        throw new UnsupportedArithmeticOperationException();
    }
}
