package com.wooyoung.toby;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class GenericLineCallbackCalculator {
	public String concatenate(String filepath) throws IOException {
		GenericLineCallback<String> concatenateCallback = new GenericLineCallback<String>() {
			public String doSomethingWithLine(String line, String value) {
				return value + line;
			}
		};
		
		return lineReadTemplate(filepath, concatenateCallback, "");
	}
	
	public Integer calcSum(String filepath) throws IOException{
		GenericLineCallback<Integer> calSumCallback = new GenericLineCallback<Integer>() {			
			public Integer doSomethingWithLine(String line, Integer value) {
				return value + Integer.valueOf(line);
			}
		};
		return lineReadTemplate(filepath, calSumCallback, 0);
	}
	
	public Integer calcMultiply(String filepath) throws IOException{
		GenericLineCallback<Integer> multiplyCallback = new GenericLineCallback<Integer>() {			
			public Integer doSomethingWithLine(String line, Integer value) {
				return value * Integer.valueOf(line);
			}
		};
		return lineReadTemplate(filepath, multiplyCallback, 1);
	}

	public <T> T lineReadTemplate(String filepath, GenericLineCallback<T> callback, T initVal) throws IOException {
		BufferedReader br = null;

		try {
			br = new BufferedReader(new FileReader(filepath));
			T result = initVal;
			String line = null;
			while ((line = br.readLine()) != null) {
				result = callback.doSomethingWithLine(line, result);
			}
			return result;
		} catch (IOException e) {
			throw e;
		} finally {
			if (br != null) {
				try {
					br.close();
				} catch (IOException e) {
					System.out.println(e.getMessage());
				}

			}
		}
	}
}
