package calculator;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CalculatorTest {

    private Calculator calculator;

    @BeforeEach
    void setUp() {
        calculator = new Calculator(0);
    }

    @Test
    void shouldAddNumber() throws UnsuportedActionException, UnsuportedCommandException {
        //given

        //when
        double result = calculator.execute("+ 4");
        //then
        assertThat(result).isEqualTo(4);
    }

    @Test
    void shouldSubtractNumber() throws UnsuportedActionException,UnsuportedCommandException {
        //given

        //when
        double result = calculator.execute("- 7");
        //then
        assertThat(result).isEqualTo(-7);
    }

    @Test
    void shouldMultiplyNumbers() throws UnsuportedActionException,UnsuportedCommandException {
        //given
        calculator.execute("+ 3.5");
        //when
        double result = calculator.execute("* 3");
        //then
        assertThat(result).isEqualTo(10.5);
    }

    @Test
    void shouldDivideNumbers() throws UnsuportedActionException,UnsuportedCommandException {
        //given
        calculator.execute("+ 7.5");
        //when
        double result = calculator.execute("/ 2.5");
        //then
        assertThat(result).isEqualTo(3);
    }

    @Test
    void shouldThrowAnException() {

        Assertions.assertThrows(UnsuportedActionException.class, () -> calculator.validation("+1"));

    }

    @Test
    void shouldThrowAnExceptionSecondVersion() {
        //given
        Exception exception = null;

        //when
        try {
            calculator.validation("+1");
            calculator.validation("% 5");
        }
         catch (UnsuportedActionException | UnsuportedCommandException e) {
            exception = e;
        }
        //then
        assertThat(exception).isNotNull();



    }

    @Test
    void shouldGivePowerOfNumber() throws UnsuportedActionException, UnsuportedCommandException {
        //given
        calculator.execute("+ 2");
        //when
        double result = calculator.execute("^ 2");
        //then
        assertThat(result).isEqualTo(4);

    }

    @Test
    void shouldGiveRootsOfNumber() throws UnsuportedActionException, UnsuportedCommandException {
        //given
        calculator.execute("+ 4");
        //when
        double result = calculator.execute("' 2");
        //then
        assertThat(result).isEqualTo(2);

    }
    @Test
    void shouldBackToPreviousValue() throws Exception {
        calculator.execute("+ 3");
        calculator.execute("+ 5");
        calculator.back();
        assertThat(calculator.value).isEqualTo(3);
    }
    @Test
    void shouldBackToPreviousValueSecondVersion() throws Exception {
        calculator.execute("+ 7");
        calculator.execute("+ 15");
        calculator.back();
        assertThat(calculator.value).isEqualTo(7);
    }
}