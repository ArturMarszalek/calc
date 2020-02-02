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
    void shouldAddNumber() throws UnsupportedCalculatorOperation, UnsupportedActionStrategyException {
        //given

        //when
        double result = calculator.execute("+ 4");
        //then
        assertThat(result).isEqualTo(4);
    }

    @Test
    void shouldSubtractNumber() throws UnsupportedCalculatorOperation, UnsupportedActionStrategyException {
        //given

        //when
        double result = calculator.execute("- 7");
        //then
        assertThat(result).isEqualTo(-7);
    }

    @Test
    void shouldMultiplyNumbers() throws UnsupportedCalculatorOperation, UnsupportedActionStrategyException {
        //given
        calculator.execute("+ 3.5");
        //when
        double result = calculator.execute("* 3");
        //then
        assertThat(result).isEqualTo(10.5);
    }

    @Test
    void shouldDivideNumbers() throws UnsupportedCalculatorOperation, UnsupportedActionStrategyException {
        //given
        calculator.execute("+ 7.5");
        //when
        double result = calculator.execute("/ 2.5");
        //then
        assertThat(result).isEqualTo(3);
    }

    @Test
    void shouldPowerNumber() throws UnsupportedCalculatorOperation, UnsupportedActionStrategyException {
        //given
        calculator.execute("+ 2");
        //when
        double result = calculator.execute("^ 2");
        //then
        assertThat(result).isEqualTo(4);
    }

    @Test
    void shouldSqrtNumber() throws UnsupportedCalculatorOperation, UnsupportedActionStrategyException {
        //given
        calculator.execute("+ 16");
        //when
        double result = calculator.execute("% 16");
        //then
        assertThat(result).isEqualTo(4);
    }

    @Test
    void shouldThrowAnExceptionWhenPatterIsInvalid() {
        //given
        UnsupportedCalculatorOperation expectedException = null;
        //when
        try {
            calculator.execute("-2");
        } catch (UnsupportedCalculatorOperation | UnsupportedActionStrategyException e) {
            expectedException = (UnsupportedCalculatorOperation) e;
        }
        //then
        assertThat(expectedException).isNotNull();
    }

    @Test
    void shouldThrowAnExceptionWhenPatterIsInvalidAgain() {
        //given
        //when
        UnsupportedCalculatorOperation expectedException = Assertions.assertThrows(UnsupportedCalculatorOperation.class,
                () -> calculator.execute("-2"));

        //then
        assertThat(expectedException).isNotNull();
    }

    @Test
    void shouldThrowAnExceptionWhenUnsupportedActionStrategyIsMade() throws UnsupportedActionStrategyException{
        //given
        UnsupportedActionStrategyException expectedException = null;
        //when
        try {
            calculator.execute(") 2");
        } catch (UnsupportedActionStrategyException | UnsupportedCalculatorOperation e) {
            expectedException = (UnsupportedActionStrategyException) e;
        }
        //then
        assertThat(expectedException).isNotNull();
    }

    @Test
    void shouldThrowAnExceptionWhenUnsupportedActionStrategyNotMade() throws UnsupportedActionStrategyException {
        //given
        //when
        UnsupportedActionStrategyException expectedException = Assertions.assertThrows(UnsupportedActionStrategyException.class,
                () -> calculator.execute("5 4"));

        //then
        assertThat(expectedException).isNotNull();
    }

}