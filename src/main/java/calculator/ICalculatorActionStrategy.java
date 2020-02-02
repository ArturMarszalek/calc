package calculator;

public interface ICalculatorActionStrategy {
    double calculate(double baseValue, double number) throws UnsupportedActionStrategyException;

}
