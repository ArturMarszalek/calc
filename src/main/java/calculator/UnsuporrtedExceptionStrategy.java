package calculator;

public class UnsuporrtedExceptionStrategy implements ICalculatorActionStrategy {

    @Override
    public double calculate(double baseValue, double number) throws ExceptionStrategy {
        throw new ExceptionStrategy();
    }
}
