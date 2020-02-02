package calculator;

public class ExponentationStrategy implements ICalculatorActionStrategy {
    @Override
    public double calculate(double baseValue, double number) {
        return Math.pow(baseValue, number);
    }
}
