package calculator;

public class PowerStrategy implements ICalculateActionStrategy {
    @Override
    public double calculate(double baseValue, double number) {
        return Math.pow(baseValue,number);
    }
}
