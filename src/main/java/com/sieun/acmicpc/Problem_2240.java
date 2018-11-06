package com.sieun.acmicpc;

import java.util.Scanner;

//자두 나무
//다이나믹 프로그래밍
//아오 어려우다
class Problem_2240 {
	static int d[][] = new int[1001][31];
	static int tree[] = new int[1001];

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int t = sc.nextInt();
		int w = sc.nextInt();

		for (int i = 1; i <= t; i++) {
			tree[i] = sc.nextInt();
		}

		int answer = 0;

		for (int i = 1; i <= t; i++) {

			// 한번도 이동하지 않았을 경우 먼저 채우기
			if (tree[i] == 1) {
				d[i][0] = d[i - 1][0] + 1;
			} else {
				d[i][0] = d[i - 1][0];
			}

			// 한번도 이동하지 않았을 경우가 최대값이 될 수 있으므로 비교 위해 변수에 담아 둠
			answer = d[i][0];

			for (int j = 1; j <= i && j <= w; j++) {
				if (tree[i] == 1 && j % 2 == 0) {
					d[i][j] = Math.max(d[i - 1][j - 1], d[i - 1][j]) + 1;
				} else if (tree[i] == 2 && j % 2 == 1) {
					d[i][j] = Math.max(d[i - 1][j - 1], d[i - 1][j]) + 1;
				} else {
					d[i][j] = Math.max(d[i - 1][j - 1], d[i - 1][j]);
				}

				// 한번도 이동하지 않았을 경우부터 j번 이동했을 경우까지의 최대값
				answer = Math.max(answer, d[i][j]);
			}
		}

		sc.close();
		System.out.println(answer);
	}
}