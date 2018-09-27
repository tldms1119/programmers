package com.sieun.programmers;

public class Sort_01 {

	public static void main(String[] args) {
		int[] array = {1, 5, 2, 6, 3, 7, 4};
		int[][] commands = {{2, 5, 3}, {4, 4, 1}, {1, 7, 3}};

		int[] answer = solution(array, commands);
		
		for(int num: answer) {
			System.out.print(num + " ");
		}
	}
	
	 public static int[] solution(int[] array, int[][] commands) {
		int[] answer = new int[commands.length];
		
		for(int i = 0; i < commands.length; i++) {
			
			int start = commands[i][0] - 1;				// commands 배열의 위치는 index 값보다 1 크므로 -1 해줘야함
			int end = commands[i][1] - 1;
			
			int[] temp = new int[end-start+1];
			System.arraycopy(array, start, temp, 0, end-start+1);
			
			sort(temp);
			answer[i] = temp[commands[i][2] - 1];
		}
		
	    return answer;
	}
	 
	 public static void sort(int[] heap) {
		 for (int i = 1; i < heap.length; i++) {
				int c = i;
				do {
					int root = (c - 1) / 2; // 특정 원소의 부모 위치 = root
					if (heap[root] < heap[c]) {
						int temp = heap[root];
						heap[root] = heap[c];
						heap[c] = temp;
					}
					c = root;
				} while (c != 0);
			}

			// 크기를 줄여가며 반복적으로 힙을 구성
			for (int i = heap.length - 1; i >= 0; i--) {
				int temp = heap[0]; // 최대값과 맨 끝 값 교체
				heap[0] = heap[i];
				heap[i] = temp;
				int root = 0;
				int c = 1;
				do {
					c = 2 * root + 1;
					// 자식 중에 더 큰 값 선택
					if (c < i - 1 && heap[c] < heap[c + 1]) { // c 크기 검사를 먼저 해줌으로써 out of bounds 방지
						c++;
					}
					// root보다 자식이 더 크면 교체
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
