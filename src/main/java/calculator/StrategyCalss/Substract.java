package calculator.StrategyCalss;

public class Substract implements CalculationActionStrategy {
    private typeOfMathAction mathActionType = typeOfMathAction.SUBSTRACT;

    @Override
    public double calculate(double first, double second) {
        return first - second;
    }
}
