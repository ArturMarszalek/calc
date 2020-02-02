package calculator;

import java.util.HashMap;
import java.util.regex.Pattern;

public class Calculator {

    double result;
    HashMap<String, ICalculatorActionStrategy> strategies = new HashMap<>();


    public Calculator() {
        strategies.put("+", new AddStrategy());
        strategies.put("*", new MultiplyStrategy());
        strategies.put("-", new SubtractStrategy());
        strategies.put("/", new DivideStrategy());
        strategies.put("^", new PowerNumbersStrategy());
        strategies.put("%", new SqrtNumbersStrategy());
    }

    public double execute(String command) throws UnsupportedPatternOpperation {
        validCommand(command);

        String[] splitCommand = command.split(" ");
        result = strategies.get(splitCommand[0]).calculate(result, Double.parseDouble(splitCommand[1]));
        return result;
    }
    public double getResult() {
        return result;
    }
    public void validCommand(String command) throws UnsupportedPatternOpperation {
        Pattern pattern = Pattern.compile("[\\^,\\!,\\+,\\-,*,\\/\\%] \\d*.?\\d+$");
//        Pattern pattern1 = Pattern.compile("sqrt \\d*.?\\d+$");
        if (!pattern.matcher(command).matches()) {
            throw new UnsupportedPatternOpperation();
        }
    }
}

