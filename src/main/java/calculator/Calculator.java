package calculator;


import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

    public class Calculator {

        HashMap<String, ICalculatorActionStrategy> strategies = new HashMap<>();
        double result;

        public Calculator(double startValue) {
            result = startValue;
            strategies.put("+", new AddStrategy());
            strategies.put("*", new MultiplyStrategy());
            strategies.put("-", new SubtractStrategy());
            strategies.put("/", new DivideStrategy());
            strategies.put("^", new PowerStrategy());
            strategies.put("%", new SqrtStrategy());
        }

        public Calculator(){
            this(0);
        }

        public double execute(String command) throws UnsupportedCalculatorOperation, UnsupportedActionStrategyException {
                validCommand(command);

                String[] splitCommand = command.split(" ");
            ICalculatorActionStrategy strategy = strategies.getOrDefault(splitCommand[0], new DefaultStrategy());
            result = strategy.calculate(result, Double.parseDouble(splitCommand[1]));

                return result;
        }
        public double getTotal() {
            return result;

        }
        public void validCommand(String command) throws UnsupportedCalculatorOperation {
            Pattern pattern = Pattern.compile("(\\S+) \\d*\\.?\\d+");
            if (!pattern.matcher(command).matches()) {
                throw new UnsupportedCalculatorOperation();
            }
        }
    }
