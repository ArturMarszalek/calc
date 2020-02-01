package calculator;

public class PlusStrategy implements ICalculatorActionStrategy {

    @Override
    public double calculate(double baseValue, double number) {
        return baseValue + number;
    }
}
