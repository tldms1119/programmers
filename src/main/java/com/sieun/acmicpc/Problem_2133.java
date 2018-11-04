package com.sieun.acmicpc;

import java.util.*;

// 타일 채우기
// 재귀적 dp 방식 말고, 차례차례로 채워나가는 ..
// 딱 떨어지는 점화식이 아닌 D[n] = 3D[n-2] + 2D[n-4] + 2D[n-6] + ... + 2D[0] 임
class Problem_2133 {
	
    static long[] d = new long[31];
    
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        d[0] = 1;
        d[2] = 3;
        
        for(int i = 4; i <= n; i += 2){
            d[i] += d[i-2]*3;
            for(int j = 4; j <= i; j += 2){
                d[i] += d[i - j]*2;
            }
        }
        
        System.out.println(d[n]);
        sc.close();
    }
   
}