package calculator.StrategyCalss;

public class Roots implements CalculationActionStrategy {
    private typeOfMathAction mathActionType = typeOfMathAction.ROOTS;

    @Override
    public double calculate(double first, double second) {
        double flipNumber = 1/second;
        double root = Math.pow(first,flipNumber );
        return root;
    }
}
