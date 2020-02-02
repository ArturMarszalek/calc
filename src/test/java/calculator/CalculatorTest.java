package calculator;

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
    void shouldAddNumber() throws UnsupportedCalculatorOpperationException {
        //given

        //when
        double result = calculator.execute("+ 4");
        //then
        assertThat(result).isEqualTo(4);
    }

    @Test
    void shouldSubtractNumber() throws UnsupportedCalculatorOpperationException {
        //given

        //when
        double result = calculator.execute("- 7");
        //then
        assertThat(result).isEqualTo(-7);
    }

    @Test
    void shouldMultiplyNumbers() throws UnsupportedCalculatorOpperationException {
        //given
        calculator.execute("+ 3.5");
        //when
        double result = calculator.execute("* 3");
        //then
        assertThat(result).isEqualTo(10.5);
    }

    @Test
    void shouldDivideNumbers() throws UnsupportedCalculatorOpperationException {
        //given
        calculator.execute("+ 7.5");
        //when
        double result = calculator.execute("/ 2.5");
        //then
        assertThat(result).isEqualTo(3);
    }

    @Test
    void shouldPowerNumbers() throws UnsupportedCalculatorOpperationException {
        //given
        calculator.execute("+ 2");


        //when
        double result = calculator.execute("^ 2");

        //then
        assertThat(result).isEqualTo(4);
    }

    @Test
    void ShouldSqrtNumbers() throws UnsupportedCalculatorOpperationException {
        //given
        calculator.execute("+ 16");


        //when
        double result = calculator.execute("# 2");

        //then
        assertThat(result).isEqualTo(4);
    }


    @Test
    void shouldThrowAnExceptionWhenPatterIsInvalid() {
        //given
        Exception expectedException = null;
        //when
        try {
            calculator.execute("-2");
        }
        catch (Exception e)
        {
            expectedException = e;
        }
        //then
        assertThat(expectedException).isNotNull();
    }

    @Test
    void shouldThrowAnExceptionWhenPatterIsInvalidAgain() {
        //given
        //when
        Exception expectedException = Assertions.assertThrows(Exception.class,
                () -> calculator.execute("-2"));

        //then
        assertThat(expectedException).isNotNull();
    }

}