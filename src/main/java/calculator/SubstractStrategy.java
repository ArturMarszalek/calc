package calculator;

public class SubstractStrategy implements ICalculatorActionStrategy {
    @Override
    public double calculate(double baseValue, double number) {
        return baseValue-number;
    }
}
