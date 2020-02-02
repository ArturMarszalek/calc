package calculator.StrategyCalss;

public class Divide implements CalculationActionStrategy {
    private typeOfMathAction mathActionType = typeOfMathAction.DIVIDE;


    @Override
    public double calculate(double first, double second) {
        return first / second;
    }
}
