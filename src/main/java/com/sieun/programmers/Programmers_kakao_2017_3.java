package com.sieun.programmers;

public class Programmers_kakao_2017_3 {

	public static void main(String[] args) {
		int n = 5; 
		int[] arr1 = {9, 20, 28, 18, 11}; 
		int[] arr2 = {30, 1, 21, 17, 28};
		
		String[] answer = new String[n];
		
		// 비트연산은 10진수 형태의 변수도 알아서 2진수로 변환해서 연산후 10진수로 반환
		for(int i = 0; i < n; i++) {
			int bit = 1;
			String temp = "";
			int result = arr1[i] | arr2[i];									// 비트연산 or
			// System.out.println(Integer.toBinaryString(result));			// 이진 수 형태로 출력하기
			for(int j = 0; j < n; j++) {
				temp = ((result & bit) > 0 ? "#" : " ") + temp;				// and (0이면 " ", 1이면 #)
				bit = bit << 1;												// 왼쪽으로 한칸씩 shift
			}
			answer[i] = temp;
		}
		
		for(String str: answer) {
			System.out.println(str);
		}

	}

}
