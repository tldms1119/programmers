package com.sieun.programmers;

//가장 긴 팰린드롬
//맨체스터 알고리즘 이라는데..
public class Programmers_12904 {
	
	public static void main(String[] args) {
		String s = "abcdcba";
		String longest = s.substring(0, 1);
		for(int i = 0; i < s.length(); i++) {
			// 홀수 팰린드롬일 경우
			String temp = getPalindrome(s, i, i);
			if(temp.length() > longest.length()) {
				longest = temp;
			}
			// 짝수 팰린드롬일 경우
			temp = getPalindrome(s, i, i + 1);
			if(temp.length() > longest.length()) {
				longest = temp;
			}
		}
		
		System.out.println(longest.length());
	}
	
	public static String getPalindrome(String s, int begin, int end) {
		while(begin >= 0 && end <= s.length() - 1 && s.charAt(begin) == s.charAt(end)) {
			begin--;
			end++;
		}
		
		return s.substring(begin + 1, end);
	}

}
