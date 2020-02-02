package calculator;




public class UnsupportedActionStrategy implements ICalculatorActionStrategy{

    @Override
    public double calculate(double result, double number) throws  UnsupportedArithmeticException {

        throw new UnsupportedArithmeticException();
    }
}
