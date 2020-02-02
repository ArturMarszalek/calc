package calculator.strategy;

import calculator.UnsupportedArtimeticOperationletters;

public interface ICalculatorStrategy {
    double calculate(Double baseValue, Double number) throws UnsupportedArtimeticOperationletters;
}
