package com.sieun.acmicpc;

import java.util.*;

// 30 배수 만들기
public class Problem_10610 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String num = sc.nextLine();
		boolean hasZero = false;							// 0을 가지고 있는지 확인
		boolean multipleThree = false;						// 3의 배수인지 확인(각자리 다 더해서)
		List<Character> list = new ArrayList<>();
		
		int sum  = 0;
		for(int i = 0; i < num.length(); i++) {
			if(num.charAt(i) == '0') {
				hasZero = true;
			}
			sum += (num.charAt(i) - '0');
			list.add(num.charAt(i));
		}
		
		if(sum % 3 == 0) multipleThree = true;
		
		if(hasZero && multipleThree) {
			Collections.sort(list);							// 가장 큰수를 찾아야 하므로 오름차순 정렬후
			Collections.reverse(list);						// 뒤집어서 내림차순 정렬 해줌
			for(char c: list) {
				System.out.print(c);
			}
		} else {
			System.out.println(-1);
		}
	
		sc.close();
	}

}
