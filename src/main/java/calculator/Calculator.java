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
    ArrayList<Double> historicalValues = new ArrayList<>();

    double value = 0;
    int historicalIndex = 1;

    public Calculator() {
        strategies.put("-", new SubtractionStrategy());
        strategies.put("+", new AddStrategy());
        strategies.put("*", new MultiplyStrategy());
        strategies.put("/", new DivisionStrategy());
        strategies.put("^", new ExponentiationStrategy());
        strategies.put("r", new RootExtractionStrategy());
        strategies.put("", new UnsupportesArithmeticOperationaStrategy());
        historicalValues.add(0.0);
    }

    public Calculator(double value) {
        this();
        this.value = value;

    }

    public void back() {
        if (historicalValues.size()==historicalIndex){historicalValues.add(value);}
        if (historicalIndex>1){historicalIndex--;}
        this.value = historicalValues.get(historicalIndex);
        System.out.println("Index : " + historicalIndex);
        System.out.println(value);
    }

    public void redo() {

        historicalIndex++;
        this.value = historicalValues.get(historicalIndex);
        System.out.println("Index : " + historicalIndex);
        System.out.println(value);
    }

    public double execute(String command) throws Exception {

        Matcher matcher = getValidate(command);
        String[] splittedCommand = matcher.group().split(" ");

        String operator = splittedCommand[0];
        String number = splittedCommand[1];

        //  value = strategies.get(operator).calculate(value, Double.parseDouble(number));
        historicalIndex++;
        historicalValues.add(value);

        value = strategies.getOrDefault(operator, new UnsupportesArithmeticOperationaStrategy()).calculate(value, Double.parseDouble(number));
        System.out.println("Index : " + historicalIndex);


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

    public java.util.Set<String> getAritmeticSymbols() {
        return strategies.keySet();
    }

    public void setValue(double value) {
        this.value = value;
    }
}

//my email validation ([\w]+[.]?)+([\w])@([\w]+[.]?)+([\w])