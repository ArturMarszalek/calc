package calculator;

public class RootStrategy implements ICalculatorActionStrategy {
    @Override
    public double calculate(double baseValue, double number) {
        return Math.pow(baseValue,1.0/number);
    }
}
