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
    void shouldAddNumber() {
        //given

        //when
        double result = calculator.execute("+ 4");
        //then
        assertThat(result).isEqualTo(4);
    }

    @Test
    void shouldSubtractNumber() {
        //given

        //when
        double result = calculator.execute("- 7");
        //then
        assertThat(result).isEqualTo(-7);
    }

    @Test
    void shouldMultiplyNumbers() {
        //given
        calculator.execute("+ 3.5");
        //when
        double result = calculator.execute("* 3");
        //then
        assertThat(result).isEqualTo(10.5);
    }

    @Test
    void shouldDivideNumbers() {
        //given
        calculator.execute("+ 7.5");
        //when
        double result = calculator.execute("/ 2.5");
        //then
        assertThat(result).isEqualTo(3);
    }

    @Test
    void shouldThrowAnException() {

        Assertions.assertThrows(UnsuportedCommandException.class, () -> calculator.validation("+1"));

    }

    @Test
    void shouldThrowAnExceptionSecondVersion() {
        //given
        UnsuportedCommandException exception = null;
        //when
        try {
            calculator.validation("+1");
        } catch (UnsuportedCommandException e) {
            exception = e;
        }
        //then
        assertThat(exception).isNotNull();

    }

    @Test
    void shouldGivePowerOfNumber() {
        //given
        calculator.execute("+ 2");
        //when
        double result = calculator.execute("^ 2");
        //then
        assertThat(result).isEqualTo(4);

    }

    @Test
    void shouldGiveRootsOfNumber() {
        //given
        calculator.execute("+ 4");
        //when
        double result = calculator.execute("' 2");
        //then
        assertThat(result).isEqualTo(2);

    }
}