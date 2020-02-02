package calculator;

public class SqrtStrategy implements ICalculatorActionStrategy {

    @Override
    public double calculate(double baseValue, double number) {
        return Math.pow(baseValue, 1.0/number);
    }
}
