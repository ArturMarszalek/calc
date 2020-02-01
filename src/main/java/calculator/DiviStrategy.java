package calculator;

public class DiviStrategy implements ICalculatorActionStrategy {

    @Override
    public double calculate(double baseValue, double number) {
        return baseValue / number;
    }
}
