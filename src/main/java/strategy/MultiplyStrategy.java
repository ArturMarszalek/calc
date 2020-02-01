package strategy;

public class MultiplyStrategy implements ICalculationActionStrategy {
    @Override
    public double calculate(double baseValue, double number) {
        return baseValue * number;
    }
}
