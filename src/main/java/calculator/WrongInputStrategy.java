package calculator;

public class WrongInputStrategy implements ICalculatorActionStrategy {

    @Override
    public double calculate(double baseValue, double number) throws Exception {
        throw new UnsupportedCalculatorOperationsException("Zły typ działania, podaj poprawny typ, ");
    }
}
