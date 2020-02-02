package calculator.strategy;

import calculator.UnsupportedArtimeticOperationletters;

public class UnsupportesArithmeticOperationaStrategy implements ICalculatorStrategy {
    @Override
    public double calculate(Double baseValue, Double number) throws UnsupportedArtimeticOperationletters {
        throw new UnsupportedArtimeticOperationletters("Podałeś nieprawidłowy znak działania");
    }
}
