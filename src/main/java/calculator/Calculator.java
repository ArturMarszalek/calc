package calculator;


import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Calculator {

    double value = 0;
    HashMap<String, ICalculatorActionStrategy> strategies = new HashMap<>();

    public Calculator() {
        strategies.put("+", new AddStrategy());
        strategies.put("*", new MultiplyStrategy());
        strategies.put("-", new SubtractStrategy());
        strategies.put("/", new DivideStrategy());
        strategies.put("^", new PowerStrategy());
        strategies.put("?" , new SqrtStrategy());
        strategies.put("default", new UnsupportedActionStrategy());
    }

    public double execute(String command) throws Exception {

        Matcher matcher = getValidate(command);
        String[] splittedCommand = matcher.group().split(" ");
        double number = Double.parseDouble(splittedCommand[1]);
        String operator = splittedCommand[0];
        value = strategies.getOrDefault(operator, new UnsupportedActionStrategy()).calculate(value, number);
        return value;
    }

    private Matcher getValidate(String command) throws UnsupportedCalculatorOperationException {

        Pattern pattern = Pattern.compile("(\\S+) \\d*\\.?\\d+");
        Matcher matcher = pattern.matcher(command);

        if (!matcher.matches()) {
            throw new UnsupportedCalculatorOperationException("Niepoprawne dane");
        }
        return matcher;
    }

    public java.util.Set<String> getAritmeticSymbols(){
        return strategies.keySet();
    }
}