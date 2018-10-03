package com.sieun.goorm;

import java.io.BufferedReader;
import java.io.InputStreamReader;

// 체스 knight 
// 4 2 F1
// 4 4 T5
public class CodingTest2 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] size = br.readLine().split(" ");

		int maxRow = Integer.parseInt(size[0]);
		int maxCol = Integer.parseInt(size[1]);

		int[][] matrix = new int[maxRow][maxCol];
		int count = 1;
		boolean isPossible = true;

		matrix[0][0] = -1;
		check(matrix, 0, 0, count);
		
		while(true) {
			boolean isExist = false;
			for (int i = 0; i < maxRow; i++) {
				for (int j = 0; j < maxCol; j++) {
					if (matrix[i][j] == count) {
						isExist = true;
					}
				}
			}
			
			if(isExist) {
				for (int i = 0; i < maxRow; i++) {
					for (int j = 0; j < maxCol; j++) {
						if (matrix[i][j] == count) {
							check(matrix, i, j, count+1);
						}
					}
				}
				count++;
			} else
				break;
			
		}

		for (int row = 0; row < maxRow; row++) {
			for (int col = 0; col < maxCol; col++) {
				if (matrix[row][col] == 0)
					isPossible = false;
				if (matrix[row][col] > count)
					count = matrix[row][col];
				System.out.print(matrix[row][col] + " ");
			}
			System.out.println();
		}

		if (isPossible)
			System.out.println("T" + (count - 1));
		else
			System.out.println("F" + (count - 1));

	}

	public static void check(int[][] matrix, int row, int col, int count) {
		int maxRow = matrix.length;
		int maxCol = matrix[0].length;

		if (row + 1 < maxRow) {
			if (col + 2 < maxCol && matrix[row + 1][col + 2] == 0) {
				matrix[row + 1][col + 2] = count;
				// check(matrix, row+1, col+2, count+1);
			}
			if (col - 2 >= 0 && matrix[row + 1][col - 2] == 0) {
				matrix[row + 1][col - 2] = count;
				// check(matrix, row+1, col-2, count+1);
			}
		}

		if (row + 2 < maxRow) {
			if (col + 1 < maxCol && matrix[row + 2][col + 1] == 0) {
				matrix[row + 2][col + 1] = count;
				// check(matrix, row+2, col+1, count+1);
			}
			if (col - 1 >= 0 && matrix[row + 2][col - 1] == 0) {
				matrix[row + 2][col - 1] = count;
				// check(matrix, row+2, col-1, count+1);
			}
		}

		if (row - 1 >= 0) {
			if (col + 2 < maxCol && matrix[row - 1][col + 2] == 0) {
				matrix[row - 1][col + 2] = count;
				// check(matrix, row-1, col+2, count+1);
			}
			if (col - 2 >= 0 && matrix[row - 1][col - 2] == 0) {
				matrix[row - 1][col - 2] = count;
				// check(matrix, row-1, col-2, count+1);
			}
		}

		if (row - 2 >= 0) {
			if (col + 1 < maxCol && matrix[row - 2][col + 1] == 0) {
				matrix[row - 2][col + 1] = count;
				// check(matrix, row-2, col+1, count+1);
			}
			if (col - 1 >= 0 && matrix[row - 2][col - 1] == 0) {
				matrix[row - 2][col - 1] = count;
				// check(matrix, row-2, col-1, count+1);
			}
		}
	}

}
