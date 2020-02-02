package calculator;

public class MultiplyStrategy implements ICalculateActionStrategy {
    @Override
    public double calculate(double baseValue, double number) {
        return baseValue * number;
    }
}
