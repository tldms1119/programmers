package com.sieun.programmers;

import java.util.Stack;

// 쇠막대기 자르기 문제
public class Stack_01 {

	public static void main(String[] args) {
		String a = "()(((()())(())()))(())";
		
		Stack<Integer> stack = new Stack<>();
		int answer = 0;
		
		for(int i = 0; i < a.length(); i++) {
			if(a.charAt(i) == '(') {
				stack.push(i);
			} else {
				// ')' 모양이고 peek(top)의 인덱스 값과 1 차이 날 때(레이저 일때!)
				if(stack.peek() + 1 == i) {
					stack.pop();
					answer += stack.size();
				} else {		// 쇠막대기의 끝일 때
					stack.pop();
					answer += 1;
				}
			}
		}
		
		System.out.println(answer);
	}

}
