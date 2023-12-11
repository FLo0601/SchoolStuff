package app;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

/**
 * Unit test for simple App.
 */
public class CalculatorTest 
{
    private final Calculator calculator = new Calculator();

    private static Stream<Arguments> integerProvider() {
        return Stream.of(
                Arguments.of(5, 4, 1),
                Arguments.of(7, 3, 4),
                Arguments.of(8, 1, 7)
                );
    }

    @ParameterizedTest
    @MethodSource("integerProvider")
    void testIntegerSubtractionMethodSource(int minuend,int subtrahend, int differenz) {
        assertEquals(differenz, calculator.integerSubtraction(minuend, subtrahend));
    }

    @ParameterizedTest
    @CsvSource({
        "5, 5, 0",
        "6, 3, 3",
        "4, 2, 2",
    })
    void testIntegerSubstractionCsvSource(int minuend, int subtrahend, int differenz) {
        assertEquals(differenz, calculator.integerSubtraction(minuend, subtrahend));
    }

    @ParameterizedTest
    @CsvFileSource(files = "/home/lorkas/Projects/calculator/src/test/java/app/testIntegers.csv", numLinesToSkip = 1)
    void testIntegerSubstractionCsvFileSource(int divident, int divisor, int quotient) {
        assertEquals(quotient, calculator.integerDivision(divident, divisor));
    }
}
