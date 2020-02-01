package strategy;

public class SubstractStrategy implements ICalculationActionStrategy {
    @Override
    public double calculate(double baseValue, double number) {
        return baseValue - number;
    }
}
