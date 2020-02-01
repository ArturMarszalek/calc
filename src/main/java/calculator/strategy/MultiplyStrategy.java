package calculator.strategy;

//mnożenie
public class MultiplyStrategy implements ICalculatorStrategy {
    @Override
    public double calculate(Double baseValue, Double number) {
        return baseValue*number;
    }
}
