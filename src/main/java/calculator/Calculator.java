package calculator;


public class Calculator {
    double result;

    public double execute(String command) {
        String[] splittedString = command.split(" ");
        double numberFromSplitting = Double.parseDouble(splittedString[1]);
        switch (splittedString[0]) {
            case "+":
                result = numberFromSplitting;
                return result;
            case "-":
                result = numberFromSplitting * -1;
                return result;
            case "*":
                result = result * numberFromSplitting;
                return result;
            case "/":
                result = result / numberFromSplitting;
                return result;
            default:
                return 0;
        }

    }


}
