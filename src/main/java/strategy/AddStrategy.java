package strategy;

public class AddStrategy implements ICalculationActionStrategy {
    @Override
    public double calculate(double baseValue, double number) {
        return baseValue + number;
    }
}
