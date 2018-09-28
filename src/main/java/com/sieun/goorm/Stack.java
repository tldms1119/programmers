package com.sieun.goorm;

public class Stack {

	Object[] stack; // 스택으로 사용할 배열
	int stackSize; // 스택의 크기
	int p; // 스택 위치

	public Stack(int size) {
		stack = new Object[size];
		stackSize = size;
		p = 0;
	}

	public void clear() {
		p = 0; // 스택 포인터를 0으로 한다.
	}

	public void push(Object x) {
		if (p >= stackSize) {
			System.out.println("Stack overflow");
		}
		p += 1;
		stack[p] = x;
	}

	public Object pop() {
		if (p <= 0) {
			System.out.println("Stack underflow");
		}
		Object temp = stack[p];
		p -= 1;
		return temp;
	}

}
