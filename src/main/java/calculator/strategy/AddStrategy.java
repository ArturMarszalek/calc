package calculator.strategy;

//dodawanie
public class AddStrategy implements ICalculatorStrategy {
    @Override
    public double calculate(Double baseValue, Double number) {
        return baseValue+number;
    }
}
