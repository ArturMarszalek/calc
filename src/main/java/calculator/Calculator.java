package calculator;


import calculator.strategy.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Calculator {
    Map<String, ICalculatorStrategy> strategies = new HashMap<>();
    Stack<Double> stack = new Stack();

    double value = 0;

    public Calculator() {
        strategies.put("-", new SubtractionStrategy());
        strategies.put("+", new AddStrategy());
        strategies.put("*", new MultiplyStrategy());
        strategies.put("/", new DivisionStrategy());
        strategies.put("^", new ExponentiationStrategy());
        strategies.put("r", new RootExtractionStrategy());
        strategies.put("", new UnsupportesArithmeticOperationaStrategy());
    }

    public Calculator(double value) {
        this();
        this.value = value;
    }

    public void back(){
        this.value = stack.pop();
        System.out.println(value);
    }

    public double execute(String command) throws Exception {

        Matcher matcher = getValidate(command);
        String[] splittedCommand = matcher.group().split(" ");

        String operator = splittedCommand[0];
        String number = splittedCommand[1];



        stack.push(value);
      //  value = strategies.get(operator).calculate(value, Double.parseDouble(number));
        value = strategies.getOrDefault(operator, new UnsupportesArithmeticOperationaStrategy()).calculate(value, Double.parseDouble(number));



        return value;

    }

    private Matcher getValidate(String command) throws UnsupportedCalculatorOperationsException {
        //  Pattern pattern = Pattern.compile("^[\\+,\\-,\\*,\\/] [\\d,.]+$"); <--- to zadziała jak używmy fond zamiast matches()
        Pattern pattern = Pattern.compile("^((\\S+) ?(\\S+)?$)");
        Matcher matcher = pattern.matcher(command);
        if (!matcher.matches()) {
            throw new UnsupportedCalculatorOperationsException("Niepoprawne dane (UnsupportedCalculatonOperationsExecutions)");
        }
        return matcher;
    }

    public java.util.Set<String> getAritmeticSymbols(){
        return strategies.keySet();
    }

    public void setValue(double value) {
        this.value = value;
    }
}

//my email validation ([\w]+[.]?)+([\w])@([\w]+[.]?)+([\w])