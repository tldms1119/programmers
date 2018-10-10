package com.sieun.programmers;

import java.util.LinkedList;
import java.util.Queue;

// 다리를 지나는 트럭 문제
// queue 이용해서 풀이
public class Stack_03 {

	public static void main(String[] args) {
		int bridge_length = 2;		// 길이라기보단 트럭이 다리를 건너는데 걸리는 시간이라 보는게 더 명확하군 
		int weight = 10; 
		int[] truck_weights = {7, 4, 5, 6};
		
		Queue<Truck> wait = new LinkedList<>();
		Queue<Truck> onBridge = new LinkedList<>();
		
		for(int w: truck_weights) {
			Truck truck = new Truck(bridge_length, w);
			wait.add(truck);
		}
		
		int time = 0;
		int total_weight = 0;
		
		total_weight += wait.peek().weight;
		onBridge.add(wait.poll());
		
		while(!onBridge.isEmpty()) {
			for(Truck truck : onBridge) {			// 다리를 건너는 중인 트럭의 남은 거리를 -1 해줌
				truck.distance--;
			}
			if(onBridge.peek().distance == 0) {		// 다리를 건너는 중인 트럭의 남은 거리가 0이면(건너편 도착했으면) pop 해줌
				total_weight -= onBridge.poll().weight;
			}
			// 한꺼번에 여러대의 트럭이 갈 수 있는지에 대한 조건문
			if(!wait.isEmpty() && weight - total_weight >= wait.peek().weight) {	
				total_weight += wait.peek().weight;
				onBridge.add(wait.poll());
			}
			time++;									
		}
		System.out.println(time+1);
		
	}
	
	static class Truck {
		int distance;
		int weight;
		
		public Truck(int distance, int weight) {
			this.distance = distance;
			this.weight = weight;
		}
	}

}
