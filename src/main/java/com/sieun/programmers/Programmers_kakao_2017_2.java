package com.sieun.programmers;

// 컬러링 북(함수의 재귀적 호출)
// 하.. 런타임 에러 못잡겠다고..
public class Programmers_kakao_2017_2 {

	public static void main(String[] args) {
		int m = 6;
		int n = 4;
		int[][] picture = { { 1, 1, 1, 0 }, { 1, 2, 2, 0 }, { 1, 0, 0, 1 }, { 0, 0, 0, 1 }, { 0, 0, 0, 3 },
				{ 0, 0, 0, 3 } };

		int numberOfArea = 0;
		int maxSizeOfOneArea = 0;

		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (picture[i][j] != 0) {
					numberOfArea++;
					int result = floodFill(picture, i, j, picture[i][j]);
					if (maxSizeOfOneArea < result) {
						maxSizeOfOneArea = result;
					}
				}
			}
		}

		int[] answer = new int[2];
		answer[0] = numberOfArea;
		answer[1] = maxSizeOfOneArea;
		System.out.println(answer[0]);
		System.out.println(answer[1]);
	}

	public static int floodFill(int[][] picture, int m, int n, int color) {
		int cnt = 0;
		int maxM = picture.length - 1;
		int maxN = picture[0].length - 1;

		// 상
		if (m > 0 && color == picture[m - 1][n]) {
			picture[m][n] = 0;
			cnt += floodFill(picture, m - 1, n, color);
		}
		// 하
		if (m < maxM && color == picture[m + 1][n]) {
			picture[m][n] = 0;
			cnt += floodFill(picture, m + 1, n, color);
		}
		// 좌
		if (n > 0 && color == picture[m][n - 1]) {
			picture[m][n] = 0;
			cnt += floodFill(picture, m, n - 1, color);
		}
		// 우
		if (n < maxN && color == picture[m][n + 1]) {
			picture[m][n] = 0;
			cnt += floodFill(picture, m, n + 1, color);
		}

		picture[m][n] = 0;
		return cnt + 1;
	}

}
