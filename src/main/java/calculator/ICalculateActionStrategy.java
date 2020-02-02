package calculator;

public interface ICalculateActionStrategy {
    public double calculate (double baseValue, double number) throws UnsupportedCalculatorOpperationException, UnsupportedArithmeticOperationException;
}
