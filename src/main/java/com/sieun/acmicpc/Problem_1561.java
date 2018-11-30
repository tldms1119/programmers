package com.sieun.acmicpc;

import java.util.Scanner;

// 1561 놀이 공원
// 이분탐색 이용
// 이분탐색 하고 범위내에 값이 있는지 한번 더 확인
public class Problem_1561 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		int[] operTime = new int[M];
		
		for(int i = 0; i < M; i++) {
			operTime[i] = sc.nextInt();
		}
		
		if(N <= M) {
			System.out.println(N);
			return;
		}
		
		// left, right 는 시간(분)
		long left = 0;
		long right = 2000000000L * 1000000L;
		while(left <= right) {
			long mid = (left + right) / 2;
			long begin = 0, end = 0;
			// 0분에는 놀이기구 종류 개수만큼 인원 탑승가능
			end = M;
			for(int i = 0; i < M; i++) {
				end += mid/operTime[i];
			}
			begin = end;
			for(int i = 0; i < M; i++) {
				if(mid % operTime[i] == 0) {
					begin -= 1;
				}
			}
			begin += 1;
			if(N < begin) {
				right = mid - 1;
			} else if(N > end) {
				left = mid + 1;
			} else {
				for(int i = 0; i < M; i++) {
					if(mid % operTime[i] == 0) {
						if(N == begin) {
							System.out.println(i+1);
							return;
						}
						begin += 1;
					}
				}
			}
		}
		
		sc.close();
	}

}
