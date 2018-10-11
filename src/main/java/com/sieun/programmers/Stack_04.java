package com.sieun.programmers;

import java.util.LinkedList;
import java.util.Queue;

// 왼쪽 탑의 높이가 자신의 높이보다 크면 수신
public class Stack_04 {

	public static void main(String[] args) {
		int[] heights = { 6, 9, 5, 7, 4 };
		 int[] answer = new int[heights.length];
	        Queue<Integer> queue = new LinkedList<>();
	        
	        for(int i = 0; i < heights.length; i++){
	            for(int j = i - 1; j >= 0; j--){
	                if(heights[i] < heights[j]){
	                    queue.add(j + 1);
	                    break;
	                }
	            }
	            if(queue.size() < i + 1)
	                queue.add(0);
	        }
	    
			for(int i = 0; i < heights.length; i++) {
				answer[i] = queue.poll();
			}
	        
			for(int i = 0; i < answer.length; i++) {
				System.out.println(answer[i]);
			}
	}

}
