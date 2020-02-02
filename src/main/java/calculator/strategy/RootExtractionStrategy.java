package calculator.strategy;

public class RootExtractionStrategy implements ICalculatorStrategy {
    @Override
    public double calculate(Double baseValue, Double number) {
        return Math.pow(baseValue,1/number);
    }
}
