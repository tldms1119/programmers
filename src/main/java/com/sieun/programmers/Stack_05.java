package com.sieun.programmers;

import java.util.ArrayList;
import java.util.List;

// 기능 개발
public class Stack_05 {

	public static void main(String[] args) {
		int[] progresses = {93, 30, 55}; 
		int[] speeds = {1, 30, 5};

        int[] day = new int[progresses.length];		// 완성까지 남은 일수를 저장하는 배열
        List<Integer> list = new ArrayList<>();	

        for(int i = 0; i < progresses.length; i++){
            float temp = (100 - progresses[i]) / (float) speeds[i];
            day[i] = (int) Math.ceil(temp);
        }

        int cnt = 1;
        int totCnt = 0;

        for(int i = 0; i < day.length; i++){
            int val = day[i];
            if(i == day.length - 1) {					// 배열의 마지막 인덱스일 때는 list에 1 추가
            	list.add(cnt);
            	break;
            }
            for(int j = i + 1; j < day.length; j++){	// i 다음부터 큰 값 만날 때까지 cnt++ 
                if(day[j] <= val){
                    cnt++;
                } else {
                    break;
                }
            }

            list.add(cnt);
            totCnt += cnt;								// 배포한 작업 수 누적
            i = totCnt - 1;								// 배포한 작업 다음부터 다시 비교 시작(for문 자체에서 +1되므로 -1 해줌)
            cnt = 1;									// 한꺼번에 배포되는 개수는 다시 1로 세팅
        }

        int[] answer = new int[list.size()];
        for(int i = 0; i < list.size(); i++){
            answer[i] = list.get(i);
            System.out.println(answer[i]);
        }
	}

}
