package calculator;

public class DivideStrategy implements ICalculatorActionStrategy {
    public double calculate(double baseValue, double number) {
        return baseValue/number;
    }
}
