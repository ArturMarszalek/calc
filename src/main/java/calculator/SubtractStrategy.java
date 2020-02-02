package calculator;

public class SubtractStrategy implements ICalculatorActionStrategy {

    @Override
    public double calculate(double baseValue, double number) {
        return baseValue - number;
    }
}
