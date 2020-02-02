package calculator;

public class PowerStrategy implements ICalculatorActionStrategy {
    public double calculate(double baseValue, double number) {
        return Math.pow(baseValue, number);
    }
}
