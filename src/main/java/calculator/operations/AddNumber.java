package calculator.operations;

public class AddNumber implements ICalcOperations {


    @Override
    public double calculate(double baseValue, double number) {
        return baseValue+number;
    }
}
