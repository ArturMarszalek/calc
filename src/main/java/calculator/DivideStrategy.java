package calculator;

public class DivideStrategy implements ICalculatorActionStrategy {
    @Override
    public double calculate(double baseValue, double number) {
        return baseValue/number;
    }
}
