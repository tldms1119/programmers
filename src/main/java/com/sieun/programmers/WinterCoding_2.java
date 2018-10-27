package com.sieun.programmers;

public class WinterCoding_2 {
	
	static int m;
	static int n;
	static int answer;
	static int[][] fromLeft = new int[11][11];
	static int[][] fromRight = new int[11][11];
	static int[][] fromUp = new int[11][11];
	static int[][] fromDown = new int[11][11];

	public static void main(String[] args) {
		 String dirs = "LR";
		 m = n = 5;
		 answer = 0;
		 
		 for(int i = 0; i < dirs.length(); i++) {
			 move(dirs.charAt(i));
		 }
		 
		 System.out.println(answer);
	}
	
	public static void move(char c) {
		if(m > 0 && c == 'U') {
			if(fromDown[m-1][n] == 0) {
				answer++;
				fromDown[m-1][n] = 1;
				fromUp[m][n] = 1;
			}
			m = m - 1;
		} else if(m < 10 && c == 'D') {
			if(fromUp[m+1][n] == 0) {
				answer++;
				fromUp[m+1][n] = 1;
				fromDown[m][n] = 1;
			}
			m = m + 1;
		} else if(n > 0 && c == 'L') {
			if(fromRight[m][n-1] == 0) {
				answer++;
				fromRight[m][n-1] = 1;
				fromLeft[m][n] = 1;
			}
			n = n - 1;
		} else if(n < 10 && c == 'R') {
			if(fromLeft[m][n+1] == 0) {
				answer++;
				fromLeft[m][n+1] = 1;
				fromRight[m][n] = 1;
			}
			n = n + 1;
		}
	}

}
