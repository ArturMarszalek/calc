package strategy;

public class RootStrategy implements ICalculationActionStrategy {


    @Override
    public double calculate(double baseValue, double number) {

        double result = Math.pow(baseValue, 1.0 / number);
        return result;
    }
}
