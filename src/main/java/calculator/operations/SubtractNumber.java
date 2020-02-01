package calculator.operations;

public class SubtractNumber implements ICalcOperations {

    @Override
    public double calculate(double baseValue, double number) {
        return baseValue-number;
    }
}
