package calculator;

import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Calculator {
    private HashMap<String, CalculatorStrategy> strategies = new HashMap<>();
    double result;



    public Calculator(double startValue) {
        result = startValue;
        strategies.put("+", new AddStrategy());
        strategies.put("-", new SubtractStrategy());
        strategies.put("*", new MultiplyStrategy());
        strategies.put("/", new DivideStrategy());
        strategies.put("^", new PowerStrategy());
        strategies.put("%", new RootsStrategy());
        //strategies.put("", new UnsuportedActionExceptionStrategy());
    }

    public double execute(String command) throws Exception {

        validCommand(command);

        String[] splitResult = command.split(" ");
        String aritmeticChar = splitResult[0];
        double number = Double.parseDouble(splitResult[1]);
        result = strategies.getOrDefault(aritmeticChar, new UnsuportedActionExceptionStrategy()).calculate(result, number);
        return result;


    }

    private void validCommand(String command) throws UnsupportedCalculatorOperationsException {
        Pattern pattern = Pattern.compile("(\\S+) \\d*\\.?\\d+");
        Matcher matcher = pattern.matcher(command);

        if (!matcher.matches()) {
            throw new UnsupportedCalculatorOperationsException("Niepoprawne dane");
        }
        String[] splittedCommand = matcher.group().split(" ");

    }
    public java.util.Set<String> getAritmeticSymbols(){
        return strategies.keySet();
    }

    public double getTotal() {
        return result;
    }
}
