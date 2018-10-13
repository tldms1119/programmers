package com.sieun.programmers;

// 주식 가격
public class Stack_06 {

	public static void main(String[] args) {
		int[] prices = { 498, 501, 470, 489 };
		int[] answer = new int[prices.length];
		
		
		for(int i = 0; i < prices.length; i++) {
			for(int j = i + 1; j < prices.length; j++) {
				if(prices[j] < prices[i]) {
					answer[i] = j - i;
					break;
				} else {
					answer[i] = j - i;
				}
			}
		}
		for(int i = 0; i < answer.length; i++) {
			System.out.println(answer[i]);
		}
	}

}
