package calculator;

public class AddStrategy implements CalculatorStrategy {

    @Override
    public double calculate(double baseValue, double splitResult) {
        return baseValue + splitResult;
    }
}
