package com.sieun.acmicpc;

import java.util.*;

// 주식
// 뒤에서부터 검사해서 현재 주가가 max 값이 아니게 될 때 주식 판매
class Problem_11501 {
	
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        
        int n = sc.nextInt();
        for(int i = 0; i < n; i++){
            int days = sc.nextInt();
            int[] stocks = new int[days];
            long benefit = 0;
            int max = 0;
            
            for(int j = 0; j < days; j++){
                stocks[j] = sc.nextInt();
            }
            
            for(int j = days-1; j >= 0; j--){
                if(stocks[j] >= max){
                    max = stocks[j];
                } else {
                    benefit += (max - stocks[j]); 
                }
            }
            System.out.println(benefit);
        }
        sc.close();
    }
    
}
