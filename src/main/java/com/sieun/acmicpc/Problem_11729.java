package com.sieun.acmicpc;

import java.util.Scanner;

// 하노이 탑
public class Problem_11729 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		System.out.printf("%d\n", (1<<n)-1);		// 하노이 탑 이동횟수는 2의 n제곱 -1
		solve(n, 1, 3);								// n개의 원판을 1-3으로 옮겨라
		
		sc.close();
	}
	
	public static void solve(int n, int x, int y) {
		if(n == 0) return;
		
		solve(n - 1, x, 6 - x - y);					// n-1개의 원판을 1-2로 옮겨라
		System.out.print(x + " ");
		System.out.println(y);
		solve(n - 1, 6 - x - y, y);					// n-1개의 원한을 2-3으로 옮겨라
	}

}
