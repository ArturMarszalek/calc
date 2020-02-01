package calculator;

public class AddStrategy implements ICalculatorActionStrategy {
    public double calculate(double baseValue, double number){
        return baseValue+number;
    }
}
