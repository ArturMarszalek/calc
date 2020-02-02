package calculator.StrategyCalss;

import calculator.UnsuportedActionException;
import calculator.UnsuportedCommandException;

public interface CalculationActionStrategy {
    public double calculate (double first, double second) throws UnsuportedActionException, UnsuportedCommandException;
}
