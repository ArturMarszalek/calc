package calculator;

public class AddStrategy implements ICalculateActionStrategy {


    @Override
    public double calculate(double baseValue, double number) {
        return baseValue + number;
    }
}
