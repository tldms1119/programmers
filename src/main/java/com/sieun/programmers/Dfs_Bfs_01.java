package com.sieun.programmers;

// 타겟 넘버
public class Dfs_Bfs_01 {
	
	static int count = 0;
	public static void main(String[] args) {
		int[] numbers = { 1, 1, 1, 1, 1 }; 
		int target = 3;
		
		dfs(numbers, target, 0);
		System.out.println(count);
	}
	
	public static void dfs(int[] numbers, int target, int i) {
		if(i < numbers.length) {
			numbers[i] *= 1;					// 첫번째 인덱스 +1 부터 dfs
			dfs(numbers, target, i + 1);		// dfs 검사 순서(+++/++-/+--/+-+/--+/---/-+-/-++)
			
			numbers[i] *= -1;
			dfs(numbers, target, i + 1);
		} else {
			int sum = 0;
			for(int n: numbers) {
				sum += n;
			}
			if(sum == target)
				count++;
		}
	}

}
