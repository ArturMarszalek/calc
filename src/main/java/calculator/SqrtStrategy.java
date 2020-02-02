package calculator;

public class SqrtStrategy implements ICalculatorActionStrategy {
    @Override
    public double calculate(double result, double number) {
        return Math.sqrt(number);
    }
}
