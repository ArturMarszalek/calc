package strategy;

public class RootStrategy implements ICalculationActionStrategy {


    @Override
    public double calculate(double baseValue, double number) {
        return StrictMath.sqrt(baseValue);
    }
}
