package com.sieun.programmers;

public class Sort_03 {

	public static void main(String[] args) {
		int[] numbers = { 3, 0, 6, 1, 5 };
		
		System.out.println(get_H_index(numbers));

	}
	
	public static int get_H_index(int[] citations) {
		sort(citations);
		int h = 0;
		
		for(int i = citations.length-1; i > 0; i--) {
			if(citations[i] == i) {
				h = citations[i];
				break;
			}
			if(citations[i] > i) {
				h = i + 1;
				break;
			}
		}
		
		return h;
	}
	
	// 내림차순으로 Heap sort
	public static void sort(int[] heap) {
		// 최소 힙 트리 구성
		 for (int i = 1; i < heap.length; i++) {
				int c = i;
				do {
					int root = (c - 1) / 2; // 특정 원소의 부모 위치 = root
					if (heap[root] > heap[c]) {
						int temp = heap[root];
						heap[root] = heap[c];
						heap[c] = temp;
					}
					c = root;
				} while (c != 0);
			}

			// 크기를 줄여가며 반복적으로 힙을 구성
			for (int i = heap.length - 1; i >= 0; i--) {
				int temp = heap[0]; // 최소값과 맨 끝 값 교체
				heap[0] = heap[i];
				heap[i] = temp;
				int root = 0;
				int c = 1;
				do {
					c = 2 * root + 1;
					// 자식 중에 더 작은 값 선택
					if (c < i - 1 && heap[c] > heap[c + 1]) { // c 크기 검사를 먼저 해줌으로써 out of bounds 방지
						c++;
					}
					// root보다 자식이 더 작으면 교체
					if (c < i && heap[root] > heap[c]) {
						temp = heap[root];
						heap[root] = heap[c];
						heap[c] = temp;
					}
					root = c;
				} while (c < i);
			}
	 }

}
