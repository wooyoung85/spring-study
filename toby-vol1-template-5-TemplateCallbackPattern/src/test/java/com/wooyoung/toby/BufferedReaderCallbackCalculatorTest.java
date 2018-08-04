package com.wooyoung.toby;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.io.IOException;

import org.junit.Before;
import org.junit.Test;

public class BufferedReaderCallbackCalculatorTest {
	BufferedReaderCallbackCalculator calculator;
	String numFilePath;
	
	@Before
	public void setup() {
		this.calculator = new BufferedReaderCallbackCalculator();
		this.numFilePath = getClass().getResource("number.txt").getPath();
	}

	@Test
	public void sumOfNumbers() throws IOException {
		assertThat(calculator.calcSum(numFilePath), is(10));
	}
	
	@Test
	public void multiplyOfNumbers() throws IOException {
		assertThat(calculator.calcMultiply(numFilePath), is(24));
	}
}
