package calculator;


public class Calculator {
    double value = 0;
    public double execute(String command) {

        String[] calculation = command.split(" ");
        switch (calculation[0]) {
            case "+":
                value += Double.parseDouble(calculation[1]);
                break;
            case "-":
                value -= Double.parseDouble(calculation[1]);
                break;
            case "*":
                value *= Double.parseDouble(calculation[1]);
                break;
            case "/":
                value /= Double.parseDouble(calculation[1]);
                break;
        }


        return value;
    }
}
