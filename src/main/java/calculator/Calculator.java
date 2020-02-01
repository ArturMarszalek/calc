package calculator;


public class Calculator {

    double result = 0;

    public double execute(String command) {

        String[] number = command.split(" ");

        switch (number[0]) {
            case "+":
                result += Double.parseDouble(number[1]);
                break;
            case "-":
                result -= Double.parseDouble(number[1]);
                break;
            case "*":
                result *=  Double.parseDouble(number[1]);
                break;
            case "/":
                result /= Double.parseDouble(number[1]);
                break;
            default:
                return result;
        }
        return result;
    }

    public double getResult() {
        return result;
    }

}
