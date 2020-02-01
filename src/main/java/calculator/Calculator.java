package calculator;


public class Calculator {

    double result;

    public double execute(String command) {
        String[] splittedString = command.split(" ");
        double numberFromSplitting = Double.parseDouble(splittedString[1]);
        switch (splittedString[0]) {
            case "+":
                result += numberFromSplitting;
                return result;
            case "-":
                result -= numberFromSplitting ;
                return result;
            case "*":
                result *= numberFromSplitting;
                return result;
            case "/":
                result /= numberFromSplitting;
                return result;
            default:
                return 0;
        }
    }

    public double total() {
        System.out.println(result);
        return result;
    }
}



