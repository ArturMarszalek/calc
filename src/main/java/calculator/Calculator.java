package calculator;


import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Calculator {
    double value = 0;
    public UnsuportedCommandException exeption;

    public void inputDate() throws UnsuportedCommandException {

        Scanner sc = new Scanner(System.in);
        System.out.println("Proszę podać działanie i liczbę ");
        Pattern pattern = Pattern.compile("[+,\\-,*,\\/] .?\\d+");
        String command = sc.nextLine();
        Matcher matcher = pattern.matcher(command);
        boolean checkString = matcher.matches();
        double value = execute(command);

        if (command.equals("exit")) {
            System.out.println("Rezultat to : " + value);
        }
        else if (!checkString){
            throw new UnsuportedCommandException();
        }
        else {
            inputDate();
        }

    }


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
