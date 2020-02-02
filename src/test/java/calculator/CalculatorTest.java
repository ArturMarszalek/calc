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
    void shouldAddNumber() throws UnsupportedActionException, UnsupportedStrategyException {
        //given
        calculator.execute("+ 4");
        //when
        double result = calculator.getResult();
        //then
        assertThat(result).isEqualTo(4);
    }

    @Test
    void shouldSubtractNumber() throws UnsupportedActionException, UnsupportedStrategyException {
        //given
        calculator.execute("- 7");
        //when
        double result = calculator.getResult();
        //then
        assertThat(result).isEqualTo(-7);
    }

    @Test
    void shouldMultiplyNumbers() throws UnsupportedActionException, UnsupportedStrategyException {
        //given
        calculator.execute("+ 3.5");
        //when
        double result = calculator.execute("* 3");
        //then
        assertThat(result).isEqualTo(10.5);
    }

    @Test
    void shouldDivideNumbers() throws UnsupportedActionException, UnsupportedStrategyException {
        //given
        calculator.execute("+ 7.5");
        //when
        double result = calculator.execute("/ 2.5");
        //then
        assertThat(result).isEqualTo(3);
    }

    @Test
    void shouldPowNumbers() throws UnsupportedActionException, UnsupportedStrategyException {
        //given
        calculator.execute("+ 3");
        //when
        double result = calculator.execute("^ 3");
        //then
        assertThat(result).isEqualTo(27);
    }

    @Test
    void shouldSqrtNumbers() throws UnsupportedActionException, UnsupportedStrategyException {
        //given
        calculator.execute("+ 27");
        //when
        double result = calculator.execute("√ 3");
        //then
        assertThat(result).isEqualTo(3);
    }

    @Test
    void shouldThrowAnExceptionWhenPatterIsInvalidAgain() {
        //given
        //when
        UnsupportedStrategyException expectedException = Assertions.assertThrows(UnsupportedStrategyException.class,
                () -> calculator.execute("! 2"));

        //then
        assertThat(expectedException).isNotNull();
    }

    @Test
    void shouldBackToPreviousValue() throws Exception {
        calculator.execute("+ 3");
        calculator.execute("+ 5");
        calculator.execute("+ 8");
        calculator.back();
        assertThat(calculator.getResult()).isEqualTo(8);
    }

    @Test
    void shouldBackToNextValue() throws Exception {
        calculator.execute("+ 3");
        calculator.execute("+ 5");
        calculator.execute("+ 8");
        calculator.back();
        calculator.back();
        calculator.reback();
        calculator.execute("+ 4");
        calculator.reback();
        assertThat(calculator.getResult()).isEqualTo(12);
    }
}