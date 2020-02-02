package calculator;

public class MultiplyStrategy implements ICalculatorActionStrategy {
    @Override
    public double calculate(double baseValue, double number) {
        return baseValue*number;
    }
}
