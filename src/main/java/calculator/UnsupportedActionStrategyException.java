package calculator;

public class UnsupportedActionStrategyException extends Throwable {

    public UnsupportedActionStrategyException calculate(double result, double parseDouble) {
        throw new UnsupportedOperationException();
    }
}

