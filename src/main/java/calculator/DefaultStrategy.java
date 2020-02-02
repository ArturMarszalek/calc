package calculator;

public class DefaultStrategy implements ICalculatorActionStrategy {
    public double calculate(double baseValue, double number) throws UnsupportedActionStrategyException {
        throw new UnsupportedActionStrategyException();
    }
}
