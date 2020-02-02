package calculator;

public class MultiplyStrategy implements CalculatorStrategy {
    @Override
    public double calculate(double baseValue, double splitResult) {
        return baseValue * splitResult;
    }
}
