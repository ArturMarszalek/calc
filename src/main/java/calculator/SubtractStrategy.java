package calculator;

public class SubtractStrategy implements CalculatorStrategy {
    @Override
    public double calculate(double baseValue, double splitResult) {
        return baseValue - splitResult;
    }
}
