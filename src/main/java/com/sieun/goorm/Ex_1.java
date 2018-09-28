package com.sieun.goorm;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// nhn 모의 테스트 1번 - 모험을 떠나요
// queue 와 비슷한 느낌이여요
public class Ex_1 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String line = sc.nextLine();
		int[] nums = new int[line.split(" ").length];

		for (int i = 0; i < line.split(" ").length; i++) {
			nums[i] = Integer.parseInt(line.split(" ")[i]);
		}

		List<Integer> items = new ArrayList<>();
		List<Integer> bin = new ArrayList<>();

		for (int i = 0; i < nums.length; i++) {
			if (items.contains(nums[i])) {
				items.remove(items.indexOf(nums[i]));
				items.add(nums[i]);
			} else {
				if (items.size() < 3) {
					items.add(nums[i]);
				} else {
					int trash = items.remove(0);
					bin.add(trash);
					items.add(nums[i]);
				}
			}

		}

		if(bin.size() == 0) {
			bin.add(0);
		}

		for (int num : bin) {
			System.out.println(num);
		}
		
		sc.close();
	}

}
