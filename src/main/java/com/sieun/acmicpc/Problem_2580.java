package com.sieun.acmicpc;

import java.util.Scanner;

// 스도쿠
// backtracking
public class Problem_2580 {
	
	static int[][] sudoku = new int[9][9]; 
	static int row, col;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
			
		for(int i = 0; i < 9; i++) {
			for(int j = 0; j < 9; j++) {
				sudoku[i][j] = sc.nextInt();
			}
		}
		
		solve();
		
		for(int i = 0; i < 9; i++) {
			for(int j = 0; j < 9; j++) {
				System.out.print(sudoku[i][j] + " ");
			}
			System.out.println();
		}
		
		sc.close();
	}
	
	public static boolean solve() {
		if(findEmpty()) {
			return true;
		}
		
		int r = row;
		int c = col;
		
		for(int n = 1; n <= 9; n++) {
			if(isCorrect(n, r, c)) {
				sudoku[r][c] = n;
				
				// findEmpty()에 의해 return true 되었을 경우
				if(solve()) {
					return true;
				}
				
				// 실패시 다시 0으로 돌림
				sudoku[r][c] = 0;
			}
		}
		// backtraking
		return false;
	}
	
	public static boolean isCorrect(int n, int r, int c) {
		if(checkRow(r, n) && checkCol(c, n) && checkBox(r, c, n)) {
			return true;
		}
		return false;
	}
	
	// 빈 공간 찾아서 좌표 지정해주는 메소드, 다 채워졌으면 true 리턴
	public static boolean findEmpty() {
		for(int i = 0; i < 9; i++) {
			for(int j = 0; j < 9; j++) {
				if(sudoku[i][j] == 0) {
					row = i;
					col = j;
					return false;
				}
			}
		}
		return true;
	}
	
	public static boolean checkRow(int r, int n) {
		for(int i = 0; i < 9; i++) {
			if(sudoku[r][i] == n) {
				return false;
			}
		}
		return true;
	}
	
	public static boolean checkCol(int c, int n) {
		for(int i = 0; i < 9; i++) {
			if(sudoku[i][c] == n) {
				return false;
			}
		}
		return true;
	}
	
	public static boolean checkBox(int r, int c,  int n) {
		int rowBox = (r / 3) * 3;
		int colBox = (c / 3) * 3;
		
		for(int i = 0; i < 3; i++) {
			for(int j = 0; j < 3; j++) {
				if(sudoku[rowBox + i][colBox + j] == n) {
					return false;
				}
			}
		}
		return true;
	}

}
