package calculator;

public class MultipleStrategy implements ICalculatorActionStrategy {

    @Override
    public double calculate(double baseValue, double number) {
        return baseValue * number;
    }
}
