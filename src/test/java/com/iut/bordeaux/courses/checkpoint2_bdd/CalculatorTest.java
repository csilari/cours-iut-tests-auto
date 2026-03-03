package com.iut.bordeaux.courses.checkpoint2_bdd;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Test;

import com.iut.bordeaux.courses.common.ICalculator;

class CalculatorTest {

    // TODO: 
    //  - initialize calculator globally
    //  - refactor test cases using Behavior-Driven Development (BDD)
    //  - rename test cases to match best practice

    @Test
    void testSum5() {
        ICalculator calc = new CalculatorImpl();
        int result = calc.sum(2, 3);
        assertThat(result).isEqualTo(5);
    }

    @Test
    void testSum8() {
        ICalculator calc = new CalculatorImpl();
        int result = calc.sum(5, 3);
        assertThat(result).isEqualTo(8);
    }

    @Test
    void testSubstractMinus1() {
        ICalculator calc = new CalculatorImpl();
        int result = calc.substract(2, 3);
        assertThat(result).isEqualTo(-1);
    }

    @Test
    void testSubstract7() {
        ICalculator calc = new CalculatorImpl();
        int result = calc.substract(7, 0);
        assertThat(result).isEqualTo(7);
    }

    @Test
    void testMultiplty6() {
        ICalculator calc = new CalculatorImpl();
        int result = calc.multiply(2, 3);
        assertThat(result).isEqualTo(6);
    }

    @Test
    void testMultiplty12() {
        ICalculator calc = new CalculatorImpl();
        int result = calc.multiply(2, 6);
        assertThat(result).isEqualTo(12);
    }

    @Test
    void testDivide6() {
        ICalculator calc = new CalculatorImpl();
        int result = calc.divide(12, 2);
        assertThat(result).isEqualTo(6);
    }

    @Test
    void testDivide3() {
        ICalculator calc = new CalculatorImpl();
        int result = calc.divide(6, 2);
        assertThat(result).isEqualTo(3);
    }
}