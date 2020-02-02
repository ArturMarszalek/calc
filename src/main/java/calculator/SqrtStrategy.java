package calculator;

public class SqrtStrategy implements ICalculatorActionStrategy {
    public double calculate(double baseValue, double number) {
        return Math.sqrt(baseValue);
    }
}
