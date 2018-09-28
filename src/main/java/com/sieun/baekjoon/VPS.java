package com.sieun.baekjoon;

import java.util.Scanner;

public class VPS {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		sc.nextLine();								// 이거 안해주면 버퍼에 \r\n 남아있어서 그거 입력한 줄 알지롱		
		
		String[] strs = new String[num];
		for(int i = 0; i < num; i++) {
			strs[i] = sc.nextLine();
		}
		
		for(String str: strs) {
			System.out.println(distinguish(str));
		}

	}
	
	public static String distinguish(String str) {
		int cnt = 0;
		for(int i = 0; i < str.length(); i++) {
			if(str.charAt(i) =='(') {
				cnt++;
			} else {
				cnt--;
			}
			
			if(cnt < 0)							// ')'가 먼저 나왔을 경우
				break;
		}
		
		if(cnt == 0) {
			return "YES";
		} else {
			return "NO";
		}
	}

}
