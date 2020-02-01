package calculator;

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
    void shouldAddNumber() throws UnsupportedCommandException {
        //given
        calculator.execute("+ 4");
        //when
        double result = calculator.getResult();
        //then
        assertThat(result).isEqualTo(4);
    }

    @Test
    void shouldSubtractNumber() throws UnsupportedCommandException {
        //given
        calculator.execute("- 7");
        //when
        double result = calculator.getResult();
        //then
        assertThat(result).isEqualTo(-7);
    }

    @Test
    void shouldMultiplyNumbers() throws UnsupportedCommandException {
        //given
        calculator.execute("+ 3.5");
        calculator.execute("* 3");
        //when
        double result = calculator.getResult();
        //then
        assertThat(result).isEqualTo(10.5);
    }

    @Test
    void shouldDivideNumbers() throws UnsupportedCommandException {
        //given
        calculator.execute("+ 7.5");
        //when
        double result = calculator.execute("/ 2.5");
        //then
        assertThat(result).isEqualTo(3);
    }
}