package calculator;

import java.util.HashMap;
import java.util.Iterator;
import java.util.ListIterator;
import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Calculator {

    private double result;
    private HashMap<String, ICalculatorActionStrategy> strategies;
    private Stack<Double> undos;
    private Stack<Double> redos;

    public Calculator(double value) {
        strategies = new HashMap<>();
        strategies.put("+", new AddStrategy());
        strategies.put("*", new MultipleStrategy());
        strategies.put("-", new SubtrackStrategy());
        strategies.put("/", new DiviStrategy());
        strategies.put("^", new PowStrategy());
        strategies.put("√", new SqrtStrategy());

        result = value;

        undos = new Stack<Double>();
        redos = new Stack<Double>();

    }

    public Calculator() {
        this(0);
    }

    public void back() {

        if (!undos.empty()) {
            redos.push(result);
            result = undos.pop();
        } else {
            System.out.println("Nie ma poprzednich liczb!");
        }
    }

    public void reback() {
        if (!redos.empty()) {
            undos.push(result);
            result = redos.pop();
        } else {
            System.out.println("Nie ma następych liczb!");
        }
    }

    public double execute(String command) throws UnsupportedActionException, UnsupportedStrategyException {

        Pattern p = Pattern.compile("^(\\S+) \\d*\\.?\\d+$");
        Matcher m = p.matcher(command);

        String[] split = command.split(" ");

        if (split.length == 1) {
            throw new UnsupportedActionException("Niewłaściwa akcja!");
        }

        String commandName = split[0];
        double number = Double.parseDouble(split[1]);

        ICalculatorActionStrategy strategy = strategies.getOrDefault(commandName, new DefaultStrategy());

        undos.push(result);
        redos.clear();

        result = strategy.calculate(result, number);
        return result;
    }

    public double getResult() {
        return result;
    }
}
