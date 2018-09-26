package com.sieun.goorm;

class Calculator {
	public int evaluate(String expression) {
		// split(), replaceAll() 함수 사용시
		// '+', '[', ']', '(', ')' 등의 문자를 사용할 때는 \\를 앞에 붙여야 한다
		String[] arr = expression.split("\\+");
		int sum = 0;
		for (String str : arr) {
			sum += Integer.parseInt(str);
		}

		return sum;
	}
}

public class G_002 {

	public static void main(String[] args) {
		Calculator calculator = new Calculator();
		int sum = calculator.evaluate("1+2+3");

		System.out.println("1+2+3 = " + sum);
	}
}
