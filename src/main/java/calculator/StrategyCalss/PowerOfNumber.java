package calculator.StrategyCalss;

public class PowerOfNumber implements CalculationActionStrategy {
    private typeOfMathAction mathActionType = typeOfMathAction.POWEROFNUMBER;


    @Override
    public double calculate(double first, double second) {
        double power = first;
        for(int i = 0; i < second -1; i++){
            power = power * first;

        }
        return power;
    }
}
