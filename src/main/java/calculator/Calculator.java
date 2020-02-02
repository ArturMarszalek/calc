package calculator;


public class Calculator {
    double value = 0;

    public double execute(String command) throws Exception {

        String[] tablica = command.split(" ");

        switch (tablica[0]) {
            case "+":
                return value += Double.parseDouble(tablica[1]);
            case "-":
                return value -= Double.parseDouble(tablica[1]);
            case "*":
                return value = value * Double.parseDouble(tablica[1]);
            case "/":
                return value = value / Double.parseDouble(tablica[1]);
            default:
                throw new Exception();
        }

    }

    public double total() {
        return value;
    }
}
