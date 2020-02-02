package calculator;

import com.sun.org.apache.xerces.internal.impl.xpath.regex.Match;

public class PowOrSquereStrategy implements ICalculatorActionStrategy {
    @Override
    public double calculate(double baseValue, double number) {
        if (number==0){
            return baseValue=1;
        }else {
            return baseValue= Math.pow(baseValue,number);
        }
    }


}
