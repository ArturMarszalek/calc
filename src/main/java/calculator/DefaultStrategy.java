package calculator;

public class DefaultStrategy implements ICalculatorActionStrategy {



    @Override
    public double calculate(double baseValue, double number) throws UnsupportedStrategyException {
        throw new UnsupportedStrategyException("Niewłaściwa strategia!");
    }
}
