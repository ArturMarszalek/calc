package calculator;


import java.util.Arrays;
import java.util.List;

public class Calculator {
    private double value = 0;

    public double execute(String action) {
        String[] items = action.split("\\s*,\\s*");
        List<String> container = Arrays.asList(items);
        int switchInfoNumber = 0;

        if (items[0] == "+") {
            switchInfoNumber = 1;
        } else if (items[0] == "-") {
            switchInfoNumber = 2;
        } else if (items[0] == "*") {
            switchInfoNumber = 3;
        } else if (items[0] == "/") {
            switchInfoNumber = 4;
        }

        switch (switchInfoNumber) {
            case 1:
                return addNumber(items[2]);
            case 2:
             return   substractNumber(items[2]);
            case 3:
               return multiplyNumbers(items[2]);

            case 4:
               return divideNumbers(items[2]);

            default:
               return 0;

        }
    }

    public double addNumber(String add) {
        double i = Double.parseDouble(add.trim());
        return value += i;
    }

    public double substractNumber(String substract) {
        double i = Double.parseDouble(substract.trim());
        return value-i;
    }

    public double multiplyNumbers(String multiply) {
        double i = Double.parseDouble(multiply.trim());
        return value*i;
    }

    public double divideNumbers(String divide) {
        double i = Double.parseDouble(divide.trim());
        return value/i;
    }


//    public double execute(String command) {
//        return 0;
//    }
}
