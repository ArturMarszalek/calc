package calculator;

public class DivideStrategy implements CalculatorStrategy {
    @Override
    public double calculate(double baseValue, double splitResult) {
        return baseValue / splitResult;
    }
}
