import calculator.Calculator;
import calculator.UnsuportedCommandException;

public class Main {
    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        try {
            calculator.inputDate();

        } catch (UnsuportedCommandException e) {
            System.out.println("Nie poprawna komenda");
        }

    }
}
