package calculator;


public class Calculator {

    double wynik = 0;

    public double execute(String command) {

        String[] split = command.split(" ");

        switch (split[0]) {
            case "+":
                wynik += Double.parseDouble(split[1]);
                break;

            case "-":
                wynik -= Double.parseDouble(split[1]);
                break;

            case "*":
                wynik *= Double.parseDouble(split[1]);
                break;

            case "/":
                wynik /= Double.parseDouble(split[1]);
                break;

        }

        return wynik;

    }

    public double total(){
        return wynik;
    }

}