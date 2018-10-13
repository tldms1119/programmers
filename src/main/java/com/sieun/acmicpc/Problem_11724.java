package com.sieun.acmicpc;

import java.util.ArrayList;
import java.util.Scanner;

// dfs 로 그래프 연결요소, 사이클 개수 찾기
public class Problem_11724 {

	public static void dfs(ArrayList<Integer>[] a, boolean[] c, int x) {
		if (c[x]) {
			return;
		}
		c[x] = true;
		for (int y : a[x]) {
			if (c[y] == false) {
				dfs(a, c, y);
			}
		}
	}

	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		ArrayList<Integer>[] a = (ArrayList<Integer>[]) new ArrayList[n + 1];
		
		for (int i = 1; i <= n; i++) {
			a[i] = new ArrayList<Integer>();
		}
		
		for (int i = 0; i < m; i++) {
			int u = sc.nextInt();
			int v = sc.nextInt();
			a[u].add(v);
			a[v].add(u);
		}
		
		boolean[] check = new boolean[n + 1];
		int ans = 0;
		for (int i = 1; i <= n; i++) {
			if (check[i] == false) {
				dfs(a, check, i);					// dfs 호출할 때마다 연결요소(사이클) 개수 추가
				ans += 1;
			}
		}
		System.out.println(ans);
		sc.close();
	}

}
