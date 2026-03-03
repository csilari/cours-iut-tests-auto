package com.iut.bordeaux.courses.checkpoint3_parameterized;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

import com.iut.bordeaux.courses.common.ICalculator;

class CalculatorTest {

    ICalculator calc = new CalculatorImpl();

    // TODO:
    // - refactor test cases using Parameterized tests
    // - find and test an "edge case"

    @Test
    void given2And3_whenSum_thenReturn5() {
        // GIVEN
        int a = 2;
        int b = 3;
        int expectedResult = 5;

        // WHEN
        int result = calc.sum(a, b);

        // THEN
        assertThat(result).isEqualTo(expectedResult);
    }

    @Test
    void given5And3_whenSum_thenReturn8() {
        // GIVEN
        int a = 5;
        int b = 3;
        int expectedResult = 8;

        // WHEN
        int result = calc.sum(a, b);

        // THEN
        assertThat(result).isEqualTo(expectedResult);
    }

    @Test
    void given2And3_whenSubstract_thenReturnMinus1() {
        // GIVEN
        int a = 2;
        int b = 3;
        int expectedResult = -1;

        // WHEN
        int result = calc.substract(a, b);

        // THEN
        assertThat(result).isEqualTo(expectedResult);
    }

    @Test
    void given7And0_whenSubstract_thenReturn7() {
        // GIVEN
        int a = 7;
        int b = 0;
        int expectedResult = 7;

        // WHEN
        int result = calc.substract(a, b);

        // THEN
        assertThat(result).isEqualTo(expectedResult);
    }

    @Test
    void given2And3_whenMultiplty_thenReturn6() {
        // GIVEN
        int a = 2;
        int b = 3;
        int expectedResult = 6;

        // WHEN
        int result = calc.multiply(a, b);

        // THEN
        assertThat(result).isEqualTo(expectedResult);
    }

    @Test
    void given2And6_whenMultiplty_thenReturn12() {
        // GIVEN
        int a = 2;
        int b = 6;
        int expectedResult = 12;

        // WHEN
        int result = calc.multiply(a, b);

        // THEN
        assertThat(result).isEqualTo(expectedResult);
    }

    @Test
    void given12And2_whenDivide_thenReturn6() {
        // GIVEN
        int a = 12;
        int b = 2;
        int expectedResult = 6;

        // WHEN
        int result = calc.divide(a, b);

        // THEN
        assertThat(result).isEqualTo(expectedResult);
    }

    @Test
    void given6And2_whenDivide_thenReturn3() {
        // GIVEN
        int a = 6;
        int b = 2;
        int expectedResult = 3;

        // WHEN
        int result = calc.divide(a, b);

        // THEN
        assertThat(result).isEqualTo(expectedResult);
    }
}