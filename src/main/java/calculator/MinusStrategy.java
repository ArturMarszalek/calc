package calculator;

public class MinusStrategy implements ICalculatorActionStrategy {

    @Override
    public double calculate(double baseValue, double number) {
        return baseValue - number;
    }
}
