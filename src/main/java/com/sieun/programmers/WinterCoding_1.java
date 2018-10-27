package com.sieun.programmers;

import java.util.HashMap;
import java.util.Map;

public class WinterCoding_1 {

	public static void main(String[] args) {
		String skill = "CBD"; 
		String[] skill_trees = {"BACDE", "CBADF", "AECB", "BDA"};
		int answer = 0;
		
		Map<Character, Integer> map = new HashMap<>();
		
		for(int i = 0; i < skill.length(); i++) {
			map.put(skill.charAt(i), i + 1);
		}
		
		for(int i = 0; i < skill_trees.length; i++) {
			int order = 0;
			
			for(int j = 0; j < skill_trees[i].length(); j++) {
				if(map.containsKey(skill_trees[i].charAt(j))) {
					if(map.get(skill_trees[i].charAt(j)) != order + 1) {
						break;
					}
					order = map.get(skill_trees[i].charAt(j));
				}
				if(j == skill_trees[i].length() - 1) { 
					answer++;
				}
			}
		}
		
		System.out.println(answer);
	}

}
