package calculator;

public class PowerStrategy implements CalculatorStrategy {
    @Override
    public double calculate(double baseValue, double splitResult) {
        return Math.pow(baseValue, splitResult);
    }
}
