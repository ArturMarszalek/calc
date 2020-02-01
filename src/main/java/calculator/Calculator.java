package calculator;


public class Calculator {

    private double result = 0;

    public double execute(String command) {

        String[] splitResult = command.split(" ");

        Double value = Double.parseDouble(splitResult[1]);


        switch (splitResult[0]) {
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
                System.out.println("Nie podbano stringa");
        }
        return result;
    }

    public double getTotal() {
        return result;
    }
}
