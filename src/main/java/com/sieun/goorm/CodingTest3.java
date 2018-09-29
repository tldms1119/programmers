package com.sieun.goorm;

import java.util.Scanner;

public class CodingTest3 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		String[] temp = sc.nextLine().split(" ");
		int n = Integer.parseInt(temp[0]);

		String[][] matrix = new String[n][n];
		for (int i = 0; i < n; i++) {
			matrix[i] = sc.nextLine().split(" ");
		}

		int sw = 0; // 0이면 clock, 1이면 reClock 호출

		String str = temp[1];
		int count = 0;
		if (str.charAt(0) == '-') { // 음수일 경우, reClock 먼저 호출
			count = Integer.parseInt(temp[1]);
			count *= -1;
			sw = 1;
		} else {
			count = Integer.parseInt(temp[1]);
		}

		for (int j = n; j > 1; j -= 2) {
			if (sw == 0) {
				for(int i = 0; i < count; i++)
					clock(j, matrix);
				sw = 1;
			} else {
				for(int i = 0; i < count; i++)
					reClock(j, matrix);
				sw = 0;
			}
		}

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				System.out.print(matrix[i][j] + " ");
			}
			System.out.println();
		}
	}

	public static void clock(int n, String[][] matrix) {
		int count = (matrix.length - n) / 2;
		int start = 0;
		int end = matrix.length;
		
		start += count;
		end -= count;

		String[][] temp = new String[matrix.length][matrix.length];

		for (int i = start; i < end; i++) {
			for (int j = start; j < end; j++) {
				if (i == start && j < end - 1) {
					temp[i][j + 1] = matrix[i][j];
				} else if (i == end - 1 && j > start) {
					temp[i][j - 1] = matrix[i][j];
				} else if (j == start && i > start) {
					temp[i - 1][j] = matrix[i][j];
				} else {
					temp[i + 1][j] = matrix[i][j];
				}
			}
		}

		for (int i = start; i < end; i++) {
			matrix[start][i] = temp[start][i];
			matrix[end - 1][i] = temp[end - 1][i];
			matrix[i][start] = temp[i][start];
			matrix[i][end - 1] = temp[i][end - 1];
		}

	}

	public static void reClock(int n, String[][] matrix) {
		int count = (matrix.length - n) / 2;
		int start = 0;
		int end = matrix.length;
		
		start += count;
		end -= count;

		String[][] temp = new String[matrix.length][matrix.length];

		for (int i = start; i < end; i++) {
			for (int j = start; j < end; j++) {
				if (i == start && j > start) {
					temp[i][j - 1] = matrix[i][j];
				} else if (i == end - 1 && j < end - 1) {
					temp[i][j + 1] = matrix[i][j];
				} else if (j == end - 1 && i > start) {
					temp[i - 1][j] = matrix[i][j];
				} else {
					temp[i + 1][j] = matrix[i][j];
				}
			}
		}

		for (int i = start; i < end; i++) {
			matrix[start][i] = temp[start][i];
			matrix[end - 1][i] = temp[end - 1][i];
			matrix[i][start] = temp[i][start];
			matrix[i][end - 1] = temp[i][end - 1];
		}
	}

}
