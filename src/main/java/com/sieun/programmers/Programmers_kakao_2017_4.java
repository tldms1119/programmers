package com.sieun.programmers;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

// 다트게임(정규표현식 사용 예제)
// Pattern p = Pattern.compile("(^[0-9]*$)");
public class Programmers_kakao_2017_4 {
	
	static int[] sum = new int[3];						// 다트는 총 3번의 기회가 주어짐(각 기회당 배열 하나씩 배당)

	public static void main(String[] args) {
		//String dartResult = "1D#2S*3S";
		String dartResult = "1S2D*3T";
		
		int answer = counting(dartResult);
		System.out.println(answer);
	}
	
	public static int counting(String score) {
		String regex = "(\\d{1,2}[S|T|D][*|#]{0,1})";		// 정규 표현식 사용(역슬래시임, 공백들어가면 안됨)
		Pattern p1 = Pattern.compile(regex+regex+regex);	
		Matcher m1 = p1.matcher(score);						// p1 패턴에 맞는지 검사해서 m1에 저장
		m1.find();											// 패턴이 일치하면 true, 아니면 false 리턴
		
		for(int i = 1; i <= m1.groupCount(); i++) {	// 정규 표현식 groupCount는 1부터 시작인가봐
			Pattern p2 = Pattern.compile("(\\d{1,2})([S|T|D])([*|#]{0,1})");
			Matcher m2 = p2.matcher(m1.group(i));
			m2.find();
			
			sum[i-1] = (int) Math.pow(Integer.parseInt(m2.group(1)), getPow(m2.group(2)));
			setOption(i, m2.group(3));
		}
		
		return sum[0] + sum[1] + sum[2];
	}
	
	public static int getPow(String m) {
		int val = 0;
		if("S".equals(m)) {
			val = 1;
		} else if ("D".equals(m)){
			val = 2;
		} else if ("T".equals(m)){
			val = 3;
		}
		return val;
	}
	
	public static void setOption(int ix, String m) {
		if("*".equals(m)) {
			sum[ix-1] *= 2;
			if(ix > 1) {
				sum[ix-2] *= 2;
			}
		} else if("#".equals(m)) {
			sum[ix-1] *= -1;
		}
	}

}
