package com.sieun.goorm;

import java.io.BufferedReader;
import java.io.InputStreamReader;

// 계수기 만들기
public class CodingTest1 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int m = Integer.parseInt(br.readLine().trim());

		int[] ni = new int[m];
		int[] value = new int[m];

		String[] temp = br.readLine().split(" ");
		boolean isValid = true;

		for (int i = 0; i < temp.length; i++) {
			ni[i] = Integer.parseInt(temp[i]);
			if (ni[i] == 0)
				isValid = false;
		}

		temp = br.readLine().split(" ");

		for (int i = 0; i < temp.length; i++) {
			value[i] = Integer.parseInt(temp[i]);
			if (ni[i] < value[i]) {
				isValid = false;
			}
		}

		int count = Integer.parseInt(br.readLine());

		if (isValid) {
			for (int i = 0; i < count; i++) {
				plus(m - 1, ni, value);
			}
			
			for(int n: value) {
				System.out.print(n);
			}
		} else {
			System.out.println(-1);
		}

	}

	public static void plus(int index, int[] ni, int[] value) {
		if (value[index] < ni[index]) {
			value[index]++;
		} else {
			value[index] = 0;
			if(index != 0)
				plus(index - 1, ni, value);
		}
	}

}
