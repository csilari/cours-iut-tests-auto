package com.iut.bordeaux.courses.checkpoint1_calculator;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Test;

import com.iut.bordeaux.courses.common.ICalculator;

class CalculatorTest {

    @Test
    void testSum5() {
        // TODO: Write a test for sum method
        ICalculator calc = new CalculatorImpl();
        int result = 5; // replace with actual call
        assertThat(result).isEqualTo(5);
    }

    @Test
    void testSum8() {
        // TODO: Write a test for sum method
        ICalculator calc = new CalculatorImpl();
        int result = 8; // replace with actual call
        assertThat(result).isEqualTo(8);
    }

    @Test
    void testSubstractMinus1() {
        // TODO: Write a test for substract method
        ICalculator calc = new CalculatorImpl();
        int result = -1; // replace with actual call
        assertThat(result).isEqualTo(-1);
    }

    @Test
    void testSubstract7() {
        // TODO: Write a test for substract method
        ICalculator calc = new CalculatorImpl();
        int result = 7; // replace with actual call
        assertThat(result).isEqualTo(7);
    }

    // TODO: Write a test for multiplty method, result must be equal to 6

    // TODO: Write a test for multiplty method, result must be equal to 12

    // TODO: Write a test for divide method, result me be equal to 6

    // TODO: Write a test for divide method, result me be equal to 3
}