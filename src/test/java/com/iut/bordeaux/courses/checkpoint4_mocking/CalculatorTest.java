package com.iut.bordeaux.courses.checkpoint4_mocking;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

import com.iut.bordeaux.courses.common.ICalculator;

class CalculatorTest {

    ICalculator calc = new CalculatorImpl();

    // Ideal when we can stick to regular types (string, int)
    @ParameterizedTest
    @CsvSource({
            "2,3,5",
            "5,3,8",
            "-1,1,0"
    })
    void givenNumbers_whenAdding_thenReturnsExpected(int a, int b, int expectedResult) {
        // GIVEN -- Params

        // WHEN
        int result = calc.sum(a, b);

        // THEN
        assertThat(result).isEqualTo(expectedResult);
    }

    // Ideal when args and output can be complex
    static Stream<Arguments> substractionArgumentsProvider() {
        return Stream.of(
                Arguments.of(2, 3, -1),
                Arguments.of(7, 0, 7),
                Arguments.of(2, 2, 0));
    }

    @ParameterizedTest
    @MethodSource("substractionArgumentsProvider")
    void givenNumbers_whenSubstraction_thenReturnsExpected(int a, int b, int expectedResult) {
        // GIVEN -- Params

        // WHEN
        int result = calc.substract(a, b);

        // THEN
        assertThat(result).isEqualTo(expectedResult);
    }

    // CsvFileSource exists if you want to use an external file
    @ParameterizedTest
    @CsvFileSource(resources = "/multiply_data.csv", numLinesToSkip = 1)
    void givenNumbers_whenMultipltying_thenReturnsExpected(int a, int b, int expectedResult) {
        // GIVEN -- Csv File

        // WHEN
        int result = calc.multiply(a, b);

        // THEN
        assertThat(result).isEqualTo(expectedResult);
    }

    // Ideal when we can stick to regular types (string, int)
    @ParameterizedTest
    @CsvSource({
            "12,2,6",
            "6,2,3",
            "-1,1,-1",
            "0,5,0"
    })
    void givenNumbers_whenDividing_thenReturnsExpected(int a, int b, int expectedResult) {
        // GIVEN -- Params

        // WHEN
        int result = calc.divide(a, b);

        // THEN
        assertThat(result).isEqualTo(expectedResult);
    }

    @Test
    void givenDivisionBy0_whenDividing_thenThrowsArithmeticException() {
        // GIVEN
        int a = 5;
        int b = 0;

        // WHEN + THEN
        assertThrows(ArithmeticException.class, () -> {
            calc.divide(a, b);
        });
    }
}