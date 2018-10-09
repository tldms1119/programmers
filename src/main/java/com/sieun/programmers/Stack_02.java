package com.sieun.programmers;

import java.util.*;

// Queue Printer
public class Stack_02 {
	// linkedList 인터페이스는 queue와 deck 인터페이스를 상속받아서 큐처럼 구현할 수 있음
	static LinkedList<Document> queue = new LinkedList<>();
	
	public static void main(String[] args) {
		int[] priorities = {2, 1, 3, 2}; 
		int location = 2;
		
		for(int i = 0; i < priorities.length; i++) {
			queue.add(new Document(i, priorities[i]));
		}
		
		List<Document> list = new ArrayList<>();
		while(!queue.isEmpty()) {
			int max = getMax();
			// document의 우선순위가 max인 경우 프린트
			if(queue.peek().getPriority() == max) {
				list.add(queue.poll());
			} else {	// 아닌 경우 pop하고 다시 뒤로 push
				queue.add(queue.peek());
				queue.poll();
			}
		}
		
		int i = 0;
		for(Document d: list) {
			if(d.getIndex() == location) {
				i = list.indexOf(d);
				break;
			}
		}
		
		System.out.println(i+1);
	}
	
	// 만약 우선순위 큐로 구현할 경우 document 객체에 대한 비교를 모르기 때문에 comparable 인터페이스의 compareTo 함수 구현해줘야함
	// 문제의 요구사항과 우선순위 큐의 정렬 순서가 조금 달라 우선순위큐 대신 LinkedList로 구현
	// 기본적으로는 오름차순으로 구현되어있음
	static class Document /* implements Comparable<Document>*/{
		private int index;
		private int priority;
		
		public Document(int index, int priority) {
			this.index = index;
			this.priority = priority;
		}
		
		public int getIndex() {
			return index;
		}

		public int getPriority() {
			return priority;
		}

		/*@Override
		public int compareTo(Document target) {
			if (this.priority > target.priority) {
	            return 1;
	        } else if (this.priority < target.priority) {
	            return -1;
	        }
	        return 0;
		}*/
	}
	
	// 가장 높은 우선순위를 구하는 static method
	public static int getMax() {
		int max = 0;
		for(int i = 0; i <queue.size(); i++) {
			if(max < queue.get(i).getPriority())
				max = queue.get(i).getPriority();
		}
		
		return max;
	}
}
