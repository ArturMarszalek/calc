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
    void shouldAddNumber() throws Exception {
        //given

        //when
        double result = calculator.execute("+ 4");
        //then
        assertThat(result).isEqualTo(4);
    }

    @Test
    void shouldSubtractNumber() throws Exception {
        //given

        //when
        double result = calculator.execute("- 7");
        //then
        assertThat(result).isEqualTo(-7);
    }

    @Test
    void shouldMultiplyNumbers() throws Exception {
        //given

        calculator.execute("+ 3.5");
        //when
        double result = calculator.execute("* 3");
        //then
        assertThat(result).isEqualTo(10.5);
    }

    @Test
    void shouldDivideNumbers() throws Exception {
        //given

        calculator.execute("+ 7.5");
        //when
        double result = calculator.execute("/ 2.5");
        //then
        assertThat(result).isEqualTo(3);
    }

    @Test
    void shouldThrowAnExceptionWhenPatterIsInvalid() {
        //given
        UnsupportedCalculatorOperationsException expectedException = null;
        //when
        try {
            calculator.execute("-2");
        }
        catch (UnsupportedCalculatorOperationsException e)
        {
            expectedException = e;
        } catch (Exception e) {
            e.printStackTrace();
        }
        //then
        assertThat(expectedException).isNotNull();
    }

    @Test
    void shouldThrowAnExceptionWhenPatterIsInvalidAgain() {
        //given
        //when
        UnsupportedCalculatorOperationsException expectedException = Assertions.assertThrows(UnsupportedCalculatorOperationsException.class,
                () -> calculator.execute("-2"));

        //then
        assertThat(expectedException).isNotNull();
    }

    @Test //potegowanie
    void shouldExponentiation() throws Exception {
        //given
        calculator.execute("+ 3");

        //when
        double result = calculator.execute("^ 3");
        //then
        assertThat(result).isEqualTo(27);

    }

    @Test //pierwiastkowanie
    void shouldRootExtraction() throws Exception {
        //given
        calculator.execute("+ 27");

        //when
        double result = calculator.execute("r 3");
        //then
        assertThat(result).isEqualTo(3);
    }
}