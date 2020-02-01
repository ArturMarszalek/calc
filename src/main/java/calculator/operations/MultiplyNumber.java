package calculator.operations;

public class MultiplyNumber implements ICalcOperations {

    @Override
    public double calculate(double baseValue, double number) {
        return baseValue*number;
    }
}
