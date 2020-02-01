package calculator;


public class Calculator {
    double value = 0;

    public double execute(String command) {
        String[] values = command.split(" ");
        String operation = values[0];
        double number = Double.parseDouble(values[1]);


        switch (operation) {
            case ("+"):
                value += number;
                break;
            case ("-"):
                value -= number;
                break;
            case ("*"):
                value *= number;
                break;
            case ("/"):

                        value /= number;
                break;
        }
        return value;
    }
}