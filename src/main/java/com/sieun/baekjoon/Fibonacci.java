package com.sieun.baekjoon;

// 계산된 값을 배열에 담아 다시금 그 값이 불릴 때 처음부터 다시 동작하지 않고 바로 값을 반환하도록
// 반복되는 계산(연쇄적)이 있을 때 사용할 수 있는 dynamic programming
// 시간 복잡도가 O(2의 n승) -> O(n)으로!
public class Fibonacci {
	
	static long[] arr = new long[50];							// n번째 피보나치 수열을 arr[n]에 담음

	public static void main(String[] args) {
		System.out.println(fibonacci(40));
		
	}
	
	public static long fibonacci(int num) {
		if(num == 0) return 0;
		if(num == 1) return 1;
		if(num == 2) return 1;
		
		if(arr[num] != 0) 										// 계산된 값이 있으면 넘기오
			return arr[num];
		
		arr[num] = fibonacci(num - 1) + fibonacci(num - 2);
		return arr[num];
	}

}
