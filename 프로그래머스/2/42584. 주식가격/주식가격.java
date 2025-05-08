import java.util.*;

class Solution {
    public int[] solution(int[] prices) {
        int n = prices.length;
        int[] answer = new int[n];
        Deque<Integer> stack = new ArrayDeque<>();
        for(int i=0;i<n;i++){
            while(!stack.isEmpty()){
                int j = stack.peek();
                if(prices[j]>prices[i]){
                    stack.pop();
                    answer[j] = i-j;
                }else break;
            }
            stack.push(i);
        }
        while(!stack.isEmpty()){
            int idx = stack.pop();
            answer[idx] = n-1-idx;
        }
        return answer;
    }
}