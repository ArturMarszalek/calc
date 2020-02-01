package calculator;


public class Calculator {
    double value = 0;

    public  double execute(String command) throws Exception {

        String[] splittedCommand = command.split(" ");
        if (splittedCommand.length != 2) {
            throw new Exception("Nieprawidłowe działanie");
        }

        String operator = splittedCommand[0];
        String number = splittedCommand[1];

        switch (operator) {
            case "+":
                value += Double.parseDouble(number);
                return value;
            case "-":
                value -= Double.parseDouble(number);
                return value;
            case "*":
                value *= Double.parseDouble(number);
                return value;
            case "/":
                value /= Double.parseDouble(number);
                return value;
//            default:
//                throw new Exception("Nieprawidłowe działanie");
        }
        return 0;

    }
}
