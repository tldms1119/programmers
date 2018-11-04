package com.sieun.acmicpc;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

// bfs
// 숨바꼭질
public class Problem_1697 {
	static int[] check = new int[100001];
    static int n, k;
    
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        k = sc.nextInt();
        System.out.println(bfs());
        sc.close();
    }
    
    public static int bfs(){
        check[n] = 1;
        Queue<Integer> queue = new LinkedList<>();
        queue.add(n);
        
        while(!queue.isEmpty()){
            int p = queue.poll();
            if(p == k) return check[p]-1;
            
            if(p - 1 >= 0 && check[p-1] == 0){
                check[p-1] = check[p] + 1;
                queue.add(p-1);
            }
            if(p + 1 <= 100000 && check[p+1] == 0){
                check[p+1] = check[p] + 1;
                queue.add(p+1);
            }
            if(2*p <= 100000 && check[2*p] == 0){
                check[2*p] = check[p] + 1;
                queue.add(2*p);
            }
        }
        return -1;
    }

}
