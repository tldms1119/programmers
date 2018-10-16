package com.sieun.programmers;

import java.util.Arrays;

//체육복
public class Greedy_01 {
	public static void main(String[] args) {
		int n = 5; 
		int[] lost = { 2, 4 }; 
		int[] reserve = { 3 };
		int[] cntClothes = new int[n];			// 학생들이 가지는 체육복의 수
		int answer = 0;
		
		Arrays.fill(cntClothes, 1);
		
		for(int i = 0; i < reserve.length; i++) {
			cntClothes[reserve[i] - 1] += 1;
		}
		
		for(int i = 0; i < lost.length; i++) {
			cntClothes[lost[i] - 1] -= 1;
			if(cntClothes[lost[i] - 1] == 0) {
				answer++;
			}
		}
	
		for(int i = 0; i < n; i++) {
			if(cntClothes[i] == 0) {
				if(i != 0 && cntClothes[i - 1] == 2) {
					answer--;
					cntClothes[i]++;
					cntClothes[i - 1]--;
				} else if(i != n - 1 && cntClothes[i + 1] == 2) {
					answer--;
					cntClothes[i]++;
					cntClothes[i + 1]--;
				}
			}
		}
		answer = n - answer;
		System.out.println(answer);
	}

}