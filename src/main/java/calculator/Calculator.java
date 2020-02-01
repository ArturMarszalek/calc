package calculator;


public class Calculator {

    private double result;

    public Calculator() {
        result = 0;
    }

    public double execute(String command) {

        String[] split = command.split(" ");

        double value = Double.parseDouble(split[1]);

        switch (split[0]) {

            case "+":
                result += value;
                break;

            case "-":
                result -= value;
                break;

            case "*":
                result *= value;
                break;

            case "/":
                result /= value;
                break;

            default:
                System.out.println("Nie podano operatora!");
                break;

        }

        return result;
    }
}
