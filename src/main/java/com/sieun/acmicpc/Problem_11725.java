package com.sieun.acmicpc;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

// 트리에서 부모 노드 구하기
public class Problem_11725 {
	
	static ArrayList<Integer>[] a;			
    static boolean[] check;				// 방문했는지 안했는지 check해주는 변수
    
    public static void bfs(int start, int[] parent) {
        Queue<Integer> q = new LinkedList<Integer>();
        q.add(start);							// 첫번째 정점 queue 담기
        check[start] = true;
        parent[1] = 0;
        while (!q.isEmpty()) {
            int x = q.remove();					// queue pop();
            for (int y : a[x]) {
                if (check[y] == false) {
                	// depth[y] = depth[x] + 1;	// dist[y] = dist[x] + 1;
                    check[y] = true;
                    parent[y] = x;				// from[y] = x;
                    q.add(y);				
                }
            }
        }
    }
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();   
        a = (ArrayList<Integer>[]) new ArrayList[n+1];		// index 1 - n 까지 확보 위해 n+1 크기로 설정 
        for (int i=1; i<=n; i++) {
            a[i] = new ArrayList<Integer>();				// a[]의 1 - n 각 index마다 간선 표현될 arrayList 선언
        }
        for (int i=0; i<n-1; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            a[u].add(v);
        }
        for (int i=1; i<=n; i++) {		
            Collections.sort(a[i]);							// 작은 번호 먼저 방문할 수 있도록 각 a[] sorting
        }
        int[] parent = new int[n+1];
        check = new boolean[n+1];							// check 배열 default로 재정비 후 bfs 시작
        bfs(1, parent);
        
        for(int i = 2; i < n+1; i++) {
        	System.out.println(parent[i]);
        }
        sc.close();
    }

}
