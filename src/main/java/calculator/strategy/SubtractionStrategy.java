package calculator.strategy;

//odejmowanie
public class SubtractionStrategy implements ICalculatorStrategy {
    @Override
    public double calculate(Double baseValue, Double number) {
        return baseValue-number;
    }
}
