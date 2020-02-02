package calculator;

public class ExponentiationStrategy implements ICalculatorActionStrategy {
    @Override
    public double calculate(double baseValue, double number) {
        double potega = Math.pow(baseValue,number);
        return potega;
    }
}
