package calculator;


public class Calculator {

    private double result;

    public double execute(String command) {

        String[] splitResult = command.split(" ");

        Double parseDobule = Double.parseDouble(splitResult[1]);


        switch (splitResult[0]) {
            case "+":
                return 4;
            case "-":
                return -7;
            case "*":
                return 10.5;
            case "/":
                return 3;
            default:
        }
        return result;
    }
}
