package calculator;

public class UnsuportedActionExceptionStrategy implements CalculatorStrategy {


    @Override
    public double calculate(double baseValue, double splitResult) throws Exception {
        throw new UnsupportedAritmeticOperationsException("Nieporpawny typ działania");
    }
}
