package calculator;

public class SubtractStrategy implements ICalculatorActionStrategy {
    public double calculate(double baseValue, double number) {
        return baseValue-number;
    }

}
