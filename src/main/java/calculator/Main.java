package calculator;

import java.util.Scanner;

public class Main {


    public static void main(String[] args) {


        try {
            Scanner scanner = new Scanner(System.in);
            boolean exit = true;
            while (exit) {
                System.out.println("Wpisz polecenie: ");
                String out = scanner.nextLine();
                if(!out.equals("exit")){
                    System.out.println(Calculator.execute(out));}
                else{
                    exit = false;
                }
            }
        } catch (Exception e) {
            System.out.println("błędne polecenie, podaj poprawne");

        }
    }
}
