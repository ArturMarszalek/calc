package calculator;

public class SubtrackStrategy implements ICalculatorActionStrategy {

    @Override
    public double calculate(double baseValue, double number) {
        return baseValue - number;
    }
}
