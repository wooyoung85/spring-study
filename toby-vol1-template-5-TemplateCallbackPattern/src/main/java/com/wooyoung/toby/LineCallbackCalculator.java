package com.wooyoung.toby;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class LineCallbackCalculator {
	public Integer calcSum(String filepath) throws IOException {
		LineCallback sumCallback = new LineCallback() {			
			public Integer doSomethingWithLine(String line, Integer value) {
				return value + Integer.valueOf(line);
			}
		};
		return fileReadTemplate(filepath, sumCallback, 0);
	}

	public Integer calcMultiply(String filepath) throws IOException {
		LineCallback multiplyCallback = new LineCallback() {
			public Integer doSomethingWithLine(String line, Integer value) {
				return value * Integer.valueOf(line);
			}
		};
		return fileReadTemplate(filepath, multiplyCallback, 1);
	}

	public Integer fileReadTemplate(String filepath, LineCallback callback, Integer initVal) throws IOException {
		BufferedReader br = null;

		try {
			br = new BufferedReader(new FileReader(filepath));
			Integer result = initVal;
			String line = null;
			while((line = br.readLine()) != null) {
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
