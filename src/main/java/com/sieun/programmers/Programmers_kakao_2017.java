package com.sieun.programmers;

// 보행자 천국(dp로 푼거라는데 나는 아직 점화식이 잘 이해가 안가네요)
public class Programmers_kakao_2017 {

	public static void main(String[] args) {
		int[][] city_map = {{0, 2, 0, 0, 0, 2}, {0, 0, 2, 0, 1, 0}, {1, 0, 0, 2, 2, 0}};
		
		int m = city_map.length;
		int n = city_map[0].length;
		
		int[][] r = new int[m+1][n+1];
		int[][] b = new int[m+1][n+1];
		
		r[1][1] = b[1][1] = 1;
		
		for(int i = 1; i <= m; i++) {
			for(int j = 1; j <= n; j++) {
				if(city_map[i-1][j-1] == 0) {
					r[i][j] = r[i][j] + r[i][j-1] + b[i-1][j];
					b[i][j] = b[i][j] + r[i][j-1] + b[i-1][j];
				} else if(city_map[i-1][j-1] == 1) {
					r[i][j] = 0;
					b[i][j] = 0;
				} else {
					r[i][j] = r[i][j-1];
					b[i][j] = b[i-1][j];
				}
			}
		}
		
		for(int i = 1; i <= m; i++) {
			for(int j = 1; j <= n; j++) {
				System.out.print(r[i][j] + " ");
			}
			System.out.println();
		}
		
		System.out.println("========================================");
		
		for(int i = 1; i <= m; i++) {
			for(int j = 1; j <= n; j++) {
				System.out.print(b[i][j] + " ");
			}
			System.out.println();
		}
		
		System.out.println(r[m][n-1] + b[m-1][n]);

	}

}
