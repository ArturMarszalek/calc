package calculator;

public class SubtractStrategy implements ICalculateActionStrategy {
    @Override
    public double calculate(double baseValue, double number) {
        return baseValue - number;
    }
}
