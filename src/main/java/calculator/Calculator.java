package calculator;


public class Calculator {

    static double value = 0;

    public static double execute(String command) throws Exception {

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
}
