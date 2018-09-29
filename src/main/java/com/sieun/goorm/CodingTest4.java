package com.sieun.goorm;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CodingTest4 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int count = sc.nextInt();
		
		int[] cards = new int[count];
		
		for(int i = 0; i < count; i++) {
			cards[i] = i + 1; 
		}
		
		int suffleCount = sc.nextInt();
		
		int n[] = new int[suffleCount];
		for(int i = 0; i < suffleCount; i++) {
			n[i] = sc.nextInt();
		}
		
		for(int num: n) {
			shuffle(num, cards, count);
		}
		
		for(int i = 0; i < 5; i++) {
			System.out.println(cards[i]);
		}

	}
	
	public static void shuffle(int n, int[] cards, int count) {
		List<Integer> temp = new ArrayList<>();
		for(int i = n; i < count-n; i++) {
			temp.add(cards[i]);
		}
		
		for(int i = 0; i < n; i++) {
			temp.add(cards[i]);
		}
		
		for(int i = count - n; i < count; i++) {
			temp.add(cards[i]);
		}
		
		for(int i = 0; i < count; i++) {
			cards[i] = temp.get(i);
		}
		
		if((count - 2*n) > 2*n) {
			shuffle(n, cards, count - 2*n);
		}
	}

}
