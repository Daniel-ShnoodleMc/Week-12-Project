package com.promineotech;

import java.util.Random;

public class TestDemo {

	public int addPositive(int a, int b) {
		
		int sum = 0;
	if (a > 0 && b > 0) {
		sum = a + b;
	} else {
		throw new IllegalArgumentException("Both parameters must be positive!");
	}
	
	return sum;
	}
	
	public int randomNumberSquared() {
		int randomInt = getRandomInt();
		return randomInt * randomInt;
	}
	
	int getRandomInt() {

	    Random random = new Random();

	    return random.nextInt(10) + 1;

	}
	
	
	
	
	
	
	
	
	
}
