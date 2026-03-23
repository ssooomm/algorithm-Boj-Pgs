import java.util.*;

class Solution {
    public long solution(int[] weights) {
        long answer = 0;
        long[] cnt = new long[1001]; 
        for(int w : weights) cnt[w]++;
        
        for(int i = 100; i <= 1000; i++){
            if(cnt[i] == 0) continue;
            
            // 1) 1:1 비율 (같은 무게끼리 조합)
            if(cnt[i] > 1) {
                answer += (cnt[i] * (cnt[i] - 1)) / 2;
            }
            
            // 2) 2:3 비율
            if(i * 3 % 2 == 0 && i * 3 / 2 <= 1000){
                answer += cnt[i] * cnt[i * 3 / 2];
            }
            
            // 3) 1:2 비율
            if (i * 2 <= 1000) {
                answer += cnt[i] * cnt[i * 2];
            }

            // 4) 3:4 비율
            if (i * 4 % 3 == 0 && i * 4 / 3 <= 1000) {
                answer += cnt[i] * cnt[i * 4 / 3];
            }
        }
        
        return answer;
    }
}