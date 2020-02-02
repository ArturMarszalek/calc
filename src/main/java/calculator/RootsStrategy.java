package calculator;

public class RootsStrategy implements CalculatorStrategy {
    @Override
    public double calculate(double baseValue, double splitResult) {
        return Math.sqrt(baseValue);
    }
}
