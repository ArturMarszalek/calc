package calculator;


import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

    public class Calculator {

        HashMap<String, ICalculatorActionStrategy> strategies = new HashMap<>();
        double result;

        public Calculator() {
            strategies.put("+", new AddStrategy());
            strategies.put("*", new MultiplyStrategy());
            strategies.put("-", new SubtractStrategy());
            strategies.put("/", new DivideStrategy());
        }

        public double execute(String command) throws UnsupportedCalculatorOperation {
            validCommand(command);

            String[] splitCommand = command.split(" ");
            result = strategies.get(splitCommand[0]).calculate(result, Double.parseDouble(splitCommand[1]));
            return result;
        }
        public double getTotal() {
            return result;
        }
        public void validCommand(String command) throws UnsupportedCalculatorOperation {
            Pattern pattern = Pattern.compile("[\\+,\\-,*,\\/] \\d*.?\\d+$");
            if (!pattern.matcher(command).matches()) {
                throw new UnsupportedCalculatorOperation();
            }
        }
    }
