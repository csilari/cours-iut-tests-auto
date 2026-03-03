package com.iut.bordeaux.courses.checkpoint2_bdd;

import com.iut.bordeaux.courses.common.ICalculator;


public class CalculatorImpl implements ICalculator {

	@Override
	public int sum(int a, int b) {
		return a + b;
	}

	@Override
	public int substract(int a, int b) {
		return a - b;
	}

	@Override
	public int divide(int a, int b) {
		return a / b;
	}

	@Override
	public int multiply(int a, int b) {
		return a * b;
	}

}
