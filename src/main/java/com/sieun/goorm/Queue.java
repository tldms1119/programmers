package com.sieun.goorm;

import java.util.ArrayList;
import java.util.List;

public class Queue {
	
	List<Integer> queue = new ArrayList<>();
	
	public void enqueue(Integer n) {
		queue.add(n);
	}
	
	public int dequeue() {
		if(queue.isEmpty()) {
			System.out.println("empty");
		}
		return queue.remove(0);
	}
	
	public boolean isEmpty() {
		return queue.isEmpty();
	}
	
}
