package calculator.strategy;

//dzielenie
public class DivisionStrategy implements ICalculatorStrategy {
    @Override
    public double calculate(Double baseValue, Double number) {
        return baseValue/number;
    }
}
