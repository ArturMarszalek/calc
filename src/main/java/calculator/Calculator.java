package calculator;


public class Calculator {
   double value = 0;

    public double execute(String command) {

        String[] splittedCommand = command.split(" ");

        String operator = splittedCommand[0];
        String number = splittedCommand[1];
        switch (operator) {
            case "+":
                value +=Double.parseDouble(number);
                return value;
            case "-":
                value -=Double.parseDouble(number);
                return value;
            case "*":
                value *=Double.parseDouble(number);
                return value;
            case "/":
                value /=Double.parseDouble(number);
                return value;

        }






        return 0;
    }
}
