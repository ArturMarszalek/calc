package calculator.StrategyCalss;

public class Add implements CalculationActionStrategy {
    private typeOfMathAction mathActionType = typeOfMathAction.ADD;



    @Override
    public double calculate(double first, double second) {
        return first + second;
    }
}
