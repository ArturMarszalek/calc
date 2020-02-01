package calculator.StrategyCalss;

import calculator.StrategyCalss.CalculationActionStrategy;

public class Add implements CalculationActionStrategy {


    @Override
    public double calculate(double first, double second) {
        return first + second;
    }
}
