package calculator.strategy;

public class ExponentiationStrategy implements  ICalculatorStrategy {
    @Override
    public double calculate(Double baseValue, Double number) {
        return Math.pow(baseValue,number);
    }
}
