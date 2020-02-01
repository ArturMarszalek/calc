package calculator;


public class Calculator {

    double result;

    public double execute(String command) {
        String[] splittedString = command.split( " ");


        switch (splittedString[0]) {
            case ("+"):
                result = Double.valueOf(splittedString[1]);
                return result;
            case "-":
                result = Double.valueOf(splittedString[1]) * -1;
                return result;
            case "*":
                result = result*Double.valueOf(splittedString[1]);
                return result;
            case "/":
                result = result/Double.valueOf(splittedString[1]);
                return result;
            default:
                return 0;
        }
    }
}

