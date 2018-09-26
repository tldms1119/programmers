package com.sieun.goorm;

import java.util.Scanner;

public class G_001 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int num = scanner.nextInt();
		
		for(int i = 1; i < num; i++){
			if(num % i == 0){
				System.out.print(i + " ");
			}
		}
		
		System.out.println(num);
		scanner.close();
	}

}
