package strategy;

public class DivideStrategy implements ICalculationActionStrategy {
    @Override
    public double calculate(double baseValue, double number) {
        return baseValue / number;
    }
}
