package com.sieun.programmers;

public class Sort_02 {

	public static void main(String[] args) {
		//int[] numbers = { 3, 30, 34, 5, 681, 68, 664, 667, 637, 631, 66, 63, 6 };
		int[] numbers = {68, 66, 681, 6, 669, 679, 687, 60};
		
		String answer = solution(numbers);

		//System.out.println(solution(numbers));
	}

	public static String solution(int[] numbers) {
		
		String[] sNumbers = new String[numbers.length];

		for(int i = 0; i < sNumbers.length; i++) {
			sNumbers[i] = Integer.toString(numbers[i]);
		}
		
		//sort(sNumbers, 0);
		sort(sNumbers, 1);
		//sort(sNumbers, 3);
		
		for(String str: sNumbers) {
			System.out.print(str + " ");
		}

		String answer = "";
		return answer;

	}

	public static void sort(String[] heap, int index) {
		for (int i = 1; i < heap.length; i++) {
			int c = i;
			do {
				int root = (c - 1) / 2; // 특정 원소의 부모 위치 = root
				char rv, cv;
				if(heap[root].length() <= index) {
					rv = heap[root].charAt(0);
				} else {
					rv = heap[root].charAt(index);
				}
				if(heap[c].length() <= index) {
					cv = heap[c].charAt(0);
				} else {
					cv = heap[c].charAt(index);
				}
				if (rv > cv) {
					String temp = heap[root];
					heap[root] = heap[c];
					heap[c] = temp;
				}
				c = root;
			} while (c != 0);
		}

		// 크기를 줄여가며 반복적으로 힙을 구성
		for (int i = heap.length - 1; i >= 0; i--) {
			String temp = heap[0]; // 최소값과 맨 끝 값 교체
			heap[0] = heap[i];
			heap[i] = temp;
			int root = 0;
			int c = 1;
			do {
				c = 2 * root + 1;
				char rv;
				char cv = 'a';
				char cpv = 'a';
				if(heap[root].length() <= index) {
					rv = heap[root].charAt(0);
				} else {
					rv = heap[root].charAt(index);
				}
				if(c < i && heap[c].length() <= index) {
					cv = heap[c].charAt(0);
				} else {
					if(c < i)
						cv = heap[c].charAt(index);
				}
				if(c < i - 1 && heap[c + 1].length() <= index) {
					cpv = heap[c + 1].charAt(0);
				} else {
					if(c < i - 1)
						cpv = heap[c + 1].charAt(index);
				}
				// 자식 중에 더 큰 작은 값 선택
				if (cpv != 'a' && cv > cpv) { 
					c++;
				}
				// root보다 자식이 더 작으면 교체
				if (cv != 'a' && rv > cv) {
					temp = heap[root];
					heap[root] = heap[c];
					heap[c] = temp;
				}
				root = c;
			} while (c < i);
		}
	}
}
