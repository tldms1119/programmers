package com.sieun.acmicpc;

import java.util.Scanner;

public class Problem_11726 {
	
	static int[] d = new int[1001];

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		System.out.println(tiling(n) % 10007);
		sc.close();
	}
	
	public static int tiling(int num) {
		if(num == 0) return 1;
		if(num == 1) return 1;
		
		if(d[num] != 0) 										
			return d[num];
		
		d[num] = tiling(num - 1) + tiling(num - 2);
		return d[num];
	}

}
