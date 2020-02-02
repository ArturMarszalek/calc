package calculator;

public class PowerStrategy implements ICalculatorActionStrategy {
    @Override
    public double calculate(double result, double number) {

        double value = Math.pow(result, number);
        return value;
    }
}
