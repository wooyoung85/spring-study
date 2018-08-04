package com.wooyoung.toby;

public interface GenericLineCallback<T> {
	T doSomethingWithLine(String line, T value);
}
