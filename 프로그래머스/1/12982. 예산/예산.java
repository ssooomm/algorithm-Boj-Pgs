import java.util.*;

class Solution {
    public int solution(int[] d, int budget) {
        int answer = 0;
        
        int d_sum = 0;
        Arrays.sort(d);
        for(int i = 0; i < d.length; i++) {
            d_sum += d[i];
            if(d_sum > budget){
                answer = i;
                break;
            }
        }
        return answer;
    }
}