package calculator;


import java.util.HashMap;
import java.util.regex.Pattern;

public class Calculator {


    double result = 0;
    HashMap<String,ICalculateActionStrategy> strategies = new HashMap<>();

    public Calculator(double startValue){
        result = startValue;

        strategies.put("+",new AddStrategy());
        strategies.put("*",new MultiplyStrategy());
        strategies.put("-", new SubtractStrategy());
        strategies.put("/", new DivideStrategy());
        strategies.put("^", new PowerStrategy());
        strategies.put("#", new SqrtNumbers());
    }

    public Calculator(){
        this(0);
    }
    public java.util.Set<String> getAvailableStringCalculator(){
        return strategies.keySet();
    }

    public double execute(String command) throws UnsupportedCalculatorOpperationException, UnsupportedArithmeticOperationException {

        validCommand(command);

        String[] tab = command.split(" ");
        String arithmeticChar = tab[0];
        double number = Double.parseDouble(tab[1]);
        return result = strategies.getOrDefault(arithmeticChar, new UnsupportedArithmeticOperationStrategy()).calculate(result, number);


    }

    public double total() {
        return result;
    }

    private void validCommand(String command) throws UnsupportedCalculatorOpperationException {
        Pattern pattern = Pattern.compile("(\\S+) \\d*\\.?\\d+");
        if (!pattern.matcher(command).matches()){
            throw new UnsupportedCalculatorOpperationException();
        }
    }
}
