package calculator.StrategyCalss;

import calculator.StrategyCalss.CalculationActionStrategy;

public class Divide implements CalculationActionStrategy {
    @Override
    public double calculate(double first, double second) {
        return first / second;
    }
}
