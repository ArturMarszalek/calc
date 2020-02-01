package calculator;

import java.util.HashMap;
import java.util.regex.Pattern;

public class Calculator {

    HashMap<String, ICalculatorActionStrategy> strategies = new HashMap<>();

    double wynik;

    public Calculator() {

        strategies.put("+", new PlusStrategy());
        strategies.put("-", new MinusStrategy());
        strategies.put("*", new MultiplyStrategy());
        strategies.put("/", new DivideStrategy());

    }

    public double execute(String command) throws UnsupportedCalculatorOperationException {
        validCommand(command);

        String[] splitCommand = command.split(" ");
        String arithmeticChar = splitCommand[0];
        double number = Double.parseDouble(splitCommand[1]);
        return wynik = strategies.get(arithmeticChar).calculate(wynik, number);

        }

    public double total(){
        return wynik;

    }

    public void validCommand(String command) throws UnsupportedCalculatorOperationException {
        Pattern pattern = Pattern.compile("[\\+,\\-,*,\\/] \\d*.?\\d+$");
        if (!pattern.matcher(command).matches()) {
            throw new UnsupportedCalculatorOperationException();
        }
    }
}