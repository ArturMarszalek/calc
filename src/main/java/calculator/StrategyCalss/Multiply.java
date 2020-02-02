package calculator.StrategyCalss;

public class Multiply implements CalculationActionStrategy {
    private typeOfMathAction mathActionType = typeOfMathAction.MULTIPLY;

    @Override
    public double calculate(double first, double second) {
        return first * second;
    }
}
