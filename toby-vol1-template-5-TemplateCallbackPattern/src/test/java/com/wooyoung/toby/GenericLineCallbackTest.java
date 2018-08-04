package com.wooyoung.toby;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.io.IOException;

import org.junit.Before;
import org.junit.Test;

public class GenericLineCallbackTest {
	GenericLineCallbackCalculator calculator;
	String numFilePath;
	
	@Before
	public void setup() {
		this.calculator = new GenericLineCallbackCalculator();
		this.numFilePath = getClass().getResource("number.txt").getPath();
	}

	@Test
	public void concatenateStrings() throws IOException {
		assertThat(calculator.concatenate(numFilePath), is("1234"));
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
