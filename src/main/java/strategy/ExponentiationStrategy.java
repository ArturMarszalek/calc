package strategy;

public class ExponentiationStrategy implements ICalculationActionStrategy {
    @Override
    public double calculate(double baseValue, double number) {
        return Math.pow(baseValue, number);
    }
}
