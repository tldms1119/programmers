package com.sieun.acmicpc;

import java.util.*;

// 1939 중량제한
// vector 이용한 그래프 인접행렬
public class Problem_1939 {

	static Vector<Edge>[] adj = new Vector[100001];
	static int N, M, I1, I2;
	static boolean[] check;
	
	static boolean checkPossible(int start, int weight) {
		// 이미 방문한 곳이면 return false;
		if(check[start]) {
			return false;
		}
		
		check[start] = true;
		// 도착지 도착
		if(start == I2) {
			return true;
		}
		
		// dfs 방식으로 중량이 통과되면 그 도착지로 다시 checkPossible 메소드 호출
		for(Edge e : adj[start]) {
			int next = e.dest;
			int w = e.weight;
			if(w >= weight) {
				if(checkPossible(next, weight)) {
					return true;
				}
			}
		}
		
		return false;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		M = sc.nextInt();
		
		for(int i = 1; i <= N; i++) {
			adj[i] = new Vector<Edge>();
		}
		
		// create adjacent matrix
		for(int i = 0; i < M; i++) {
			int from = sc.nextInt();
			int to = sc.nextInt();
			int w = sc.nextInt();
			
			adj[from].add(new Edge(to, w));
			adj[to].add(new Edge(from, w));
		}
		
		I1 = sc.nextInt();
		I2 = sc.nextInt();
		
		int answer = 0, m = 0;
		int left = 0;
		int right = 1000000000;
		while(left <= right) {
			m = (left + right) / 2;
			// 체크할 때마다 false로 set
			check = new boolean[N+1];
			if(checkPossible(I1, m)) {
				answer = m;
				left = m + 1;
			} else {
				right = m - 1;
			}
		}
		
		System.out.println(answer);

	}
	
	static class Edge {
		int dest;
		int weight;
		
		public Edge(int dest, int weight) {
			this.dest = dest;
			this.weight = weight;
		}
	}

}

