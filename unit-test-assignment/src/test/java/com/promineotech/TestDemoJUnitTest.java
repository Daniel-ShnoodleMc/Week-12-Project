package com.promineotech;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.params.provider.Arguments.arguments;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.spy;

import java.util.stream.Stream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class TestDemoJUnitTest {

	private TestDemo testDemo;
	
	
	
	@BeforeEach
	void setUp() throws Exception {
		testDemo = new TestDemo();
	}

	@Test
	void assertThatNumberSquaredIsCorrect() {
		TestDemo mockDemo = spy(testDemo);
		doReturn(5).when(mockDemo).getRandomInt();
		
		int fiveSquared = mockDemo.randomNumberSquared();
		
		assertThat(fiveSquared).isEqualTo(25);
	}
	
	
	
	
	
	
	
	
	@Test
	void assertThatPairsOfPositiveNumbersAreAddedCorrectly() {
		assertThat(testDemo.addPositive(7, 4)).isEqualTo(11);
		assertThat(testDemo.addPositive(1, 6)).isEqualTo(7);
		assertThat(testDemo.addPositive(5, 8)).isEqualTo(13);
		assertThat(testDemo.addPositive(2, 3)).isEqualTo(5);
		assertThat(testDemo.addPositive(9, 6)).isEqualTo(15);
	}
	
	@Test
	void assertThatPairsOfNegativeNumbersAreAddedCorrectly() {
		assertThat(testDemo.addPositive(-2, -4)).isEqualTo(-6);
		assertThat(testDemo.addPositive(-5, -8)).isEqualTo(-13);
		assertThat(testDemo.addPositive(-9, -1)).isEqualTo(-10);
		assertThat(testDemo.addPositive(-7, -3)).isEqualTo(-10);
		assertThat(testDemo.addPositive(-6, -9)).isEqualTo(-15);
	}
	
	
	
	@ParameterizedTest
	@MethodSource("com.promineotech.TestDemoJUnitTest#argumentsForAddPositive")
	void assertThatTwoPositiveNumbersAreAddedCorrectly(int a, int b, int expected, boolean expectException) {
		if(!expectException) {

			  assertThat(testDemo.addPositive(a, b)).isEqualTo(expected);
			} else {
		assertThatThrownBy(() ->

	    testDemo.addPositive(a, b))
	        .isInstanceOf(IllegalArgumentException.class);
			}
	}
	
	static Stream<Arguments> argumentsForAddPositive() {
		return Stream.of(
				arguments(2, 4, 6, false),
				arguments(4, -7, -3, true),
				arguments(-2, -8, -10, true),
				arguments(5, 3, 8, false),
				arguments(9, 8, 17, false),
				arguments(5, -4, 1, true),
				arguments(4, 3, 7, false),
				arguments(-9, 0, -9, true),
				arguments(5, 2, 7, false)
				);
	}

}
