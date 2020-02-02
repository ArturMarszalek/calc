package calculator.StrategyCalss;


import calculator.UnsuportedCommandException;

public class UnsupportedOperationStrategy implements CalculationActionStrategy {


    @Override
    public double calculate(double first, double second)throws UnsuportedCommandException
    {
        throw new UnsuportedCommandException();
    }
}
