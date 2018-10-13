package com.sieun.acmicpc;

import java.util.*;

// dfs, bfs
public class Problem_1260 {

	static ArrayList<Integer>[] a;		// 그래프의 인접 리스트 - 시간 복잡도 O(V+E)
    static boolean[] check;				// 방문했는지 안했는지 check해주는 변수
   
    public static void dfs(int x) {
        if (check[x]) {
            return;
        }
        check[x] = true;
        System.out.print(x + " ");
        for (int y : a[x]) {
            if (check[y] == false) {
                dfs(y);
            }
        }
    }
    
    public static void bfs(int start) {
        Queue<Integer> q = new LinkedList<Integer>();
        q.add(start);							// 첫번째 정점 queue 담기
        check[start] = true;
        while (!q.isEmpty()) {
            int x = q.remove();					// queue pop();
            System.out.print(x + " ");
            for (int y : a[x]) {
                if (check[y] == false) {
                    check[y] = true;
                    q.add(y);				
                }
            }
        }
    }
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int start = sc.nextInt();
        a = (ArrayList<Integer>[]) new ArrayList[n+1];		// index 1 - n 까지 확보 위해 n+1 크기로 설정 
        for (int i=1; i<=n; i++) {
            a[i] = new ArrayList<Integer>();				// a[]의 1 - n 각 index마다 간선 표현될 arrayList 선언
        }
        for (int i=0; i<m; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            a[u].add(v);									// 양방향 그래프라서 서로 넣어줌
            a[v].add(u);
        }
        for (int i=1; i<=n; i++) {		
            Collections.sort(a[i]);							// 작은 번호 먼저 방문할 수 있도록 각 a[] sorting
        }
        check = new boolean[n+1];							// check 배열 선언하고(default=false) dfs 시작
        dfs(start);
        System.out.println();
        check = new boolean[n+1];							// check 배열 default로 재정비 후 bfs 시작
        bfs(start);
        System.out.println();
        
        sc.close();
    }

}
