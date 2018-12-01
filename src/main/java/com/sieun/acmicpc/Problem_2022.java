package com.sieun.acmicpc;

import java.util.Scanner;

// 2022 사다리
// 건물 사이의 너비 구하기
public class Problem_2022 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		double x = sc.nextDouble();
		double y = sc.nextDouble();
		double c = sc.nextDouble();
		
		double left = 0;
		double right = Math.min(x, y);
		
		// 실수라서 = 비교가 의미가 없고, mid + 1/ mid - 1을 할 수 없기때문에 left < right 비교가 의미 없음
		while(Math.abs(right - left) > 1e-6) {
			double mid = (left + right) / 2.0;
			
			// 두 빌딩 사이의 거리
			double d = mid;
			
			// x를 빗변으로 가지는 삼각형의 높이
			double h1 = Math.sqrt(x*x - d*d);
			
			// y를 빗변으로 가지는 삼각형의 높이
			double h2 = Math.sqrt(y*y - d*d);
			
			// 닮음을 이용한 수식 도출(c의 길이 계산)
			double h = (h1 * h2) / (h1 + h2);
			
			// 계산한 h가 기존의 c보다 크면 d의 길이가 좀더 넓어져야함
			// 답이 실수일 수 있기 때문에 mid + 1/ mid - 1 적용할 수 없음
			if(h > c) {
				left = mid;
			} else {
				right = mid;
			}
		}
		
		// 소수점 4째 자리에서 반올림해서 소수점 3째 자리까지 출력
		System.out.printf("%.3f\n", left);
		
		sc.close();
	}
	
}
