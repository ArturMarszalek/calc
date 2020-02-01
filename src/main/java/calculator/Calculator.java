package calculator;


public class Calculator {

    double result = 0;

    public double execute(String command) {

        String[] tab = command.split(" ");

        switch (tab[0]) {
            case "+":
                result += Double.parseDouble(tab[1]);
                break;
            case "-":
                result -= Double.parseDouble(tab[1]);
                break;
            case "*":
                result *=  Double.parseDouble(tab[1]);
                break;
            case "/":
                result /= Double.parseDouble(tab[1]);
                break;
            default:
                return result;
        }
        return result;
    }
}
