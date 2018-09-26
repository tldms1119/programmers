package com.sieun.programmers;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Hash_03 {

	public static void main(String[] args) {
		String[][] clothes = {{"yellow_hat", "headgear"},
								{"blue_sunglasses", "eyewear"}, 
								{"green_turban", "headgear"}};
		
		System.out.println(solution(clothes));
	}
	
	 public static int solution(String[][] clothes) {
	        Map<String, Integer> map = new HashMap<>();
	        
	        for(String[] sort : clothes){
	            String str = sort[1];
	            if(map.get(str) != null){
	                map.put(str, map.get(str) + 1);
	            } else {
	                map.put(str, 1);   
	            }
	        }
	        
	        int answer = 1;
	        Set<String> set = map.keySet();
	        for(String sort : set) {
	        	answer *= (map.get(sort) + 1);
	        }
	       
	        return answer - 1;
	    }

}
