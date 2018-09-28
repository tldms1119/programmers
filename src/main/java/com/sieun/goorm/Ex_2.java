package com.sieun.goorm;

import java.util.Scanner;

// DFS (깊이 우선 탐색) 을 이용한 알고리즘..?
public class Ex_2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		sc.nextLine();
		String[][] temp = new String[num][num];
		int[][] matrix = new int[num][num];

		for (int i = 0; i < num; i++) {
			temp[i] = sc.nextLine().split(" ");
		}

		for (int i = 0; i < num; i++) {
			for (int j = 0; j < num; j++) {
				matrix[i][j] = Integer.parseInt(temp[i][j]);
			}
		}

		int count = 0;											// 영역 개수
		int[] width = new int[50];								// 임시로 배열크기 정하고 넓이 저장
		for (int i = 0; i < num; i++) {
			for (int j = 0; j < num; j++) {
				if (matrix[i][j] == 1) {
					count++;									// 영역 개수 증가
					width[count - 1]++;							// 넓이 1 추가
					matrix[i][j] = 0;							// 읽은 1은 헷갈리지 않게 0으로 바꿔줌
					findOne(i, j, matrix, width, count);
				}
			}
		}
		
		sc.close();

		if (count != 0) {										// 영역이 존재하면
			int[] temp2 = new int[count];						// 정렬 위해 크기에 맞는 배열 담아줌
			System.arraycopy(width, 0, temp2, 0, 3);
			heapSort(temp2);

			System.out.println(count);
			for (int i = 0; i < count; i++) {
				System.out.print(temp2[i] + " ");
			}
		} else {
			System.out.println(0);
		}

		
	}

	// 오른쪽, 아래, 왼쪽, 위 차례로 검사
	public static void findOne(int i, int j, int[][] matrix, int[] width, int count) {
		// 오른쪽
		if (j < matrix[i].length - 1 && matrix[i][j + 1] == 1) {
			width[count - 1]++;
			matrix[i][j + 1] = 0;
			findOne(i, j + 1, matrix, width, count);
		}

		// 아래쪽
		if (i < matrix[i].length - 1 && matrix[i + 1][j] == 1) {
			width[count - 1]++;
			matrix[i + 1][j] = 0;
			findOne(i + 1, j, matrix, width, count);
		}

		// 왼쪽
		if (j > 0 && matrix[i][j - 1] == 1) {
			width[count - 1]++;
			matrix[i][j - 1] = 0;
			findOne(i, j - 1, matrix, width, count);
		}

		// 위쪽
		if (i > 0 && matrix[i - 1][j] == 1) {
			width[count - 1]++;
			matrix[i - 1][j] = 0;
			findOne(i - 1, j, matrix, width, count);
		}
	}

	public static void heapSort(int[] heap) {

		for (int i = 1; i < heap.length; i++) {
			int c = i;
			do {
				int root = (c - 1) / 2;
				if (heap[root] < heap[c]) {
					int temp = heap[root];
					heap[root] = heap[c];
					heap[c] = temp;
				}
				c = root;
			} while (c != 0);
		}

		for (int i = heap.length - 1; i >= 0; i--) {
			int temp = heap[0];
			heap[0] = heap[i];
			heap[i] = temp;
			int root = 0;
			int c = 1;
			do {
				c = 2 * root + 1;
				if (c < i - 1 && heap[c] < heap[c + 1]) {
					c++;
				}
				if (c < i && heap[root] < heap[c]) {
					temp = heap[root];
					heap[root] = heap[c];
					heap[c] = temp;
				}
				root = c;
			} while (c < i);
		}

	}

}
