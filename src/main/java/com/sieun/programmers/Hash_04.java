package com.sieun.programmers;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Hash_04 {
	public static void main(String[] args) {
		String[] genres = {"classic", "pop", "classic", "classic", "pop"};
		int[] plays = {500, 600, 150, 800, 2500};
		
		for(int num: solution(genres, plays)) {
			System.out.print(num + " ");
		}
	}
	
	public static int[] solution(String[] genres, int[] plays) {
        int[] temp = new int[100];						// 선곡될 총 곡수를 모르니까 임시 배열로 두자
        Map<String, Integer> map = new HashMap<>();
        
        for(int i = 0; i < genres.length; i++) {		// Key = 장르, Value = 장르별 총 재생 횟수
        	String genre = genres[i];
        	if(map.containsKey(genre)) {
        		map.put(genre, map.get(genre) + plays[i]);
        	} else {
        		map.put(genre, plays[i]);
        	}
        }
        
        Set<String> set = map.keySet();					
        int position = 0;								// temp 배열 index 가리키는 변수
        
        while(!map.isEmpty()) {							// genres 에 담긴 모든 장르가 선곡될 때 까지
        	int max = 0;
        	String key = "";
        	for(String genre : set) {					// 가장 많이 재생된 장르를 찾는 for문
            	if(map.get(genre) > max) {
            		max = map.get(genre);
            		key = genre;
            	}
            }
        	map.remove(key);							// key 값 알아낸 후 map에서 remove
        	int[] arr = compare(genres, plays, key);	// 같은 장르 안에서 재생횟수 비교(두곡 선곡위해)
        	for(int num: arr) {
        		if(num != -1) {							// 배열 값이 -1 이면 장르당 한곡이 존재하는 것임(선곡할 두번째 곡이 없음)
        			temp[position] = num;
        			position++;							// temp index 위치 증가
        		}
        	}
        }
        
        int[] answer = new int[position];				// 선곡된 곡 개수만큼 배열 생성시켜줌
        for(int i = 0; i < position; i++) {
        	answer[i] = temp[i];
        }
        
        return answer;
    }
	
	public static int[] compare(String[] genres, int[] plays, String key) {
		int first = -1, second = -1;					// 인덱스 용 변수니까 확실한 구분위해 -1
		
		for(int i = 0; i < genres.length; i++) {		// key 와 같은 장르를 가지는 것들 중 재생횟수가 큰 두개 골라냄		
			if(genres[i].equals(key)) {					
				if(first != -1) {					
					if(plays[first] < plays[i]) {		
						second = first;
						first = i;
					} else {
						if(second != -1) {
							if(plays[second] < plays[i]) {
								second = i;
							}
						} else {
							second = i;
						}
					}
				} else {
					first = i;
				}
			}
		}
		int[] arr = new int[2];
		arr[0] = first;
		arr[1] = second;
		return arr;
	}
}
