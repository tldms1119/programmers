package com.sieun.programmers;

//하노이 탑(2차원 배열로 출력)
public class Programmers_12946 {
	public static int cnt = -1;

	public static void main(String[] args) {
		int n = 3;

		int[][] answer = new int[(int) Math.pow(2, n)-1][2];
		solve(n, 1, 3, answer);

		for(int i = 0; i < Math.pow(2, n)-1; i++) {
			System.out.print(answer[i][0] + " ");
			System.out.println(answer[i][1]);
		}

	}

	public static void solve(int n, int x, int y, int[][] answer){
	        if(n == 0) return;
	        solve(n-1, x, 6-x-y, answer);
	        cnt++;
	        answer[cnt][0] = x;
	        answer[cnt][1] = y;
	        solve(n-1, 6-x-y, y, answer);
	}
}
