package calculator;



import java.util.Scanner;

public class Calculator {
    double value = 0;

    public double execute(String command) {

        String [] operator = command.split(" ");

        switch(operator[0])
        {
            case "+":
                value += Double.parseDouble(operator[1]);
                break;

           case "-":
            value -= Double.parseDouble(operator[1]);
            break;

            case "*":
                value *= Double.parseDouble(operator[1]);
                break;

            case "/":
                value /= Double.parseDouble(operator[1]);
                break;

        }
        return value;


    }
}
