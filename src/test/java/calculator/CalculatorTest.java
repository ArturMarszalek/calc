package calculator;

import calculator.exceptions.CantDivideByZeroException;
import calculator.exceptions.UnsupportedPatternOpperationException;
import calculator.exceptions.UnsupportedStrategyOperationException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CalculatorTest {

    private Calculator calculator;

    @BeforeEach
    void setUp() {
        calculator = new Calculator();
    }

    @Test
    void shouldAddNumber() throws UnsupportedPatternOpperationException, CantDivideByZeroException, UnsupportedStrategyOperationException {
        //given
        //when
        double result = calculator.execute("+ 4");
        //then
        assertThat(result).isEqualTo(4);
    }

    @Test
    void shouldSubtractNumber() throws UnsupportedPatternOpperationException, CantDivideByZeroException, UnsupportedStrategyOperationException {
        //given
        //when
        double result = calculator.execute("- 7");
        //then
        assertThat(result).isEqualTo(-7);
    }

    @Test
    void shouldMultiplyNumbers() throws UnsupportedPatternOpperationException, CantDivideByZeroException, UnsupportedStrategyOperationException {
        //given
        calculator.execute("+ 3.5");
        //when
        double result = calculator.execute("* 3");
        //then
        assertThat(result).isEqualTo(10.5);
    }

    @Test
    void shouldDivideNumbers() throws UnsupportedPatternOpperationException, CantDivideByZeroException, UnsupportedStrategyOperationException {
        //given
        calculator.execute("+ 7.5");
        //when
        double result = calculator.execute("/ 2.5");
        //then
        assertThat(result).isEqualTo(3);
    }

    @Test
    void shouldNotDivideNumbers() throws UnsupportedPatternOpperationException, CantDivideByZeroException, UnsupportedStrategyOperationException {
        //given
        calculator.execute("+ 7.5");
        //when
        //then
        Assertions.assertThrows(CantDivideByZeroException.class, () -> calculator.execute("/ 0"));
    }

    @Test
    void shouldThrowUnsupportedPatternException() {
        //given
        //when
        //then
        Assertions.assertThrows(UnsupportedPatternOpperationException.class,
                () -> calculator.execute("sd 2.5"));
    }

    @Test
    void shouldShowTotal() throws UnsupportedPatternOpperationException, CantDivideByZeroException, UnsupportedStrategyOperationException {
        //given
        calculator.execute("+ 7.5");
        //when
        calculator.execute("/ 2.5");
        //then
        assertThat(calculator.getResult()).isEqualTo(3);
    }

    @Test
    void shouSqrtNumbers() throws CantDivideByZeroException, UnsupportedPatternOpperationException, UnsupportedStrategyOperationException {
        //given
        //when
        double result = calculator.execute("sqrt 4");
        //then
        assertThat(result).isEqualTo(2);
    }

    @Test
    void shouldPowerNumbers() throws CantDivideByZeroException, UnsupportedPatternOpperationException, UnsupportedStrategyOperationException {
        //given
        calculator.execute("+ 2");
        //when
        double result = calculator.execute("^ 2");
        //then
        assertThat(result).isEqualTo(4);
    }

    @Test
    void shouldBackToPreviousValue() throws Exception, CantDivideByZeroException {
        //given
        calculator.execute("+ 3");
        calculator.execute("+ 5");
        //when
        calculator.back();
        //then
        assertThat(calculator.result).isEqualTo(3);
    }
}