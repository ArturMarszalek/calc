package calculator;

public class SqrtNumbers implements ICalculateActionStrategy {
    @Override
    public double calculate(double baseValue, double number) {
        double wynik = Math.pow(baseValue, 1 / number);
        return wynik;
    }
}
