package calculator;

public class MultiplyStrategy implements ICalculatorActionStrategy {


    @Override
    public double calculate(double result, double number) {
        return result-number;
    }
}
