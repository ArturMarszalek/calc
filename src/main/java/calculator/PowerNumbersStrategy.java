package calculator;

public class PowerNumbersStrategy implements ICalculatorActionStrategy {
    @Override
    public double calculate(double baseValue, double number) {
        return Math.pow(baseValue, number);
    }
}
