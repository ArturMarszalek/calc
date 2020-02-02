package calculator;

public class DivideStrategy implements ICalculatorActionStrategy {
    @Override
    public double calculate(double result, double number) {
        return result/number;
    }
}
