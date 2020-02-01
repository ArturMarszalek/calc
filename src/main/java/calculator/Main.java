package calculator;

public class Main {
    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        System.out.println(calculator.execute("+ 10"));
        System.out.println(calculator.execute("- 2"));
        System.out.println(calculator.execute("* 2"));
        System.out.println(calculator.execute("/ 2"));


    }
}
