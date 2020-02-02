package calculator;


import java.util.HashMap;
import java.util.regex.Pattern;

public class Calculator {


    double result = 0;
    HashMap<String,ICalculateActionStrategy> strategies = new HashMap<>();

    public Calculator(){

        strategies.put("+",new AddStrategy());
        strategies.put("*",new MultiplyStrategy());
        strategies.put("-", new SubtractStrategy());
        strategies.put("/", new DivideStrategy());
        strategies.put("^", new PowerStrategy());
        strategies.put("#", new SqrtNumbers());
    }

    public double execute(String command) throws UnsupportedCalculatorOpperationException {

        validCommand(command);

        String[] tab = command.split(" ");
        String arithmeticChar = tab[0];
        double number = Double.parseDouble(tab[1]);
        return result = strategies.get(arithmeticChar).calculate(result, number);


    }

    public double total() {
        return result;
    }

    private void validCommand(String command) throws UnsupportedCalculatorOpperationException {
        Pattern pattern = Pattern.compile("[\\+\\-\\*\\/\\^\\#] \\d*\\.?\\d+");
        if (!pattern.matcher(command).matches()){
            throw new UnsupportedCalculatorOpperationException();
        }
    }
}
