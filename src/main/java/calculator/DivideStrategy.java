package calculator;

public class DivideStrategy implements ICalculateActionStrategy {

    @Override
    public double calculate(double baseValue, double number) {
        return baseValue / number;
    }
}
