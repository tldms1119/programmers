package com.sieun.acmicpc;

import java.util.Arrays;
import java.util.Scanner;

// 1654 랜선 자르기
// 이분 탐색
public class Problem_1654 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int k = sc.nextInt();
		int n = sc.nextInt();
		
		int[] cables = new int[k]; 
		
		for(int i = 0; i < k; i++) {
			cables[i] = sc.nextInt();
		}
		
		Arrays.sort(cables);
		
		long left = 1;
		long right = cables[k-1];
		long mid = 0;
		long answer = 0;
		
		while(left <= right) {
			int count = 0;
			mid = (left + right) / 2;
			
			for(int length: cables) {
				count += length/mid;
			}
			
			if(count < n) {
				right = mid - 1;
			} else {
				answer = Math.max(answer, mid);
				left = mid + 1;
			} 
		}
		
		System.out.println(answer);
	}

}
