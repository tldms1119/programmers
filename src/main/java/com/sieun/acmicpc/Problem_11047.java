package com.sieun.acmicpc;

import java.util.Scanner;

//동전 0 (Greedy algorithm)
public class Problem_11047 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();				// 동전 단위 개수
		int[] a = new int[n];				// 동전 단위 입력받을 배열
		int answer = 0;						
		int k = sc.nextInt();
		
		for(int i = 0; i < n; i++) {
			a[i] = sc.nextInt();			// 동전 단위 오름차순으로 입력
		}

		for(int i = n - 1; i >= 0; i--) {
			answer += k/a[i];
			k = k%a[i];
			if(k == 0) break;
		}
		
		System.out.println(answer);
		sc.close();
	}
}