import java.util.*;

class Solution {
    public int[] solution(int[] prices) {
        int len = prices.length;
        int[] answer = new int[len];
        Deque<Integer> dq = new ArrayDeque<>();
        
        for(int i=0;i<len;i++){
            while(!dq.isEmpty()){
                if(prices[dq.peek()]>prices[i]){
                    int idx = dq.pop();
                    answer[idx] = i-idx;
                }else break;
            }
            dq.push(i);
        }
        
        while(!dq.isEmpty()){
            int idx = dq.pop();
            answer[idx] = len-1-idx;
        }
        return answer;
    }
}