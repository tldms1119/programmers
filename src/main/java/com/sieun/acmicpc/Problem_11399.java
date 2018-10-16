package com.sieun.acmicpc;

import java.util.*;

//ATM (Greedy Algorithm)
//오름차순(정확히는 비내림차순) 정렬해야 대기시간의 총합이 최소값이 나옴
public class Problem_11399 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		List<Integer> list = new ArrayList<>();
		
		for(int i = 0; i < n; i++) {
			list.add(sc.nextInt());
		}
		
		Collections.sort(list);
		int sum = 0;
		int answer = 0;
		for(int i = 0; i < list.size(); i++) {
			sum += list.get(i);
			answer += sum;
		}
		System.out.println(answer);
		sc.close();
	}
}