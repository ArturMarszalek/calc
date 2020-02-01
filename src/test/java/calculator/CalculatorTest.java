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
    void    shouldAddNumber() throws UnsupportedPatternOpperationException, CantDivideByZeroException {
        //given

        //when
        double result = calculator.execute("+ 4");
        //then
        assertThat(result).isEqualTo(4);
    }

    @Test
    void shouldSubtractNumber() throws UnsupportedPatternOpperationException, CantDivideByZeroException {
        //given

        //when
        double result = calculator.execute("- 7");
        //then
        assertThat(result).isEqualTo(-7);
    }

    @Test
    void shouldMultiplyNumbers() throws UnsupportedPatternOpperationException, CantDivideByZeroException {
        //given
        calculator.execute("+ 3.5");
        //when
        double result = calculator.execute("* 3");
        //then
        assertThat(result).isEqualTo(10.5);
    }

    @Test
    void shouldDivideNumbers() throws UnsupportedPatternOpperationException, CantDivideByZeroException {
        //given
        calculator.execute("+ 7.5");
        //when
        double result = calculator.execute("/ 2.5");
        //then
        assertThat(result).isEqualTo(3);
    }
    @Test
    void shouldNotDivideNumbers() throws UnsupportedPatternOpperationException, CantDivideByZeroException {
        //given
        calculator.execute("+ 7.5");
        //when
        double result = calculator.execute("/ 0");
        //then
        assertThat(result).isEqualTo(3);
    }
    @Test
    void shouldThrowUnsupportedPatternException() throws UnsupportedPatternOpperationException, CantDivideByZeroException {
        //given
        calculator.execute("+7.5");
        //when
        double result = calculator.execute("/ 2.5");
        //then
        assertThat(result).isEqualTo(3);
    }
    @Test
    void shouldShowTotal() throws UnsupportedPatternOpperationException, CantDivideByZeroException {
        //given
        calculator.execute("+7.5");
        //when
        double result = calculator.execute("/ 2.5");
        //then
        calculator.execute("total");
        assertThat(result).isEqualTo(3);
    }
}