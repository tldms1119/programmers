package com.sieun.programmers;

import java.util.*;

// 완전 탐색 모의고사
public class FullSearch_01 {

	public static void main(String[] args) {
		int[] answers = { 3, 3, 1, 1, 2, 2, 4, 4, 5 };
		
		int[] pattern1 = { 1, 2, 3, 4, 5 };
		int[] pattern2 = { 2, 1, 2, 3, 2, 4, 2, 5 };
		int[] pattern3 = { 3, 3, 1, 1, 2, 2, 4, 4, 5, 5 };
		
		int[] score = new int[3];
		
		for(int i = 0; i < answers.length; i++) {
			if(answers[i] == pattern1[i % 5]) {
				score[0]++;
			}
			if(answers[i] == pattern2[i % 8]) {
				score[1]++;
			}
			if(answers[i] == pattern3[i % 10]) {
				score[2]++;
			}
		}
		
		int maxScore = Math.max(score[0], Math.max(score[1], score[2]));
        ArrayList<Integer> list = new ArrayList<>();
        if(maxScore == score[0]) {list.add(1);}
        if(maxScore == score[1]) {list.add(2);}
        if(maxScore == score[2]) {list.add(3);}
        //return list.stream().mapToInt(i->i.intValue()).toArray();
		
        int[] answer = new int[list.size()];
        
		for(int i = 0; i < list.size(); i++) {
			answer[i] = list.get(i);
		}
	
	}

}
