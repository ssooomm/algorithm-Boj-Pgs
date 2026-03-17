import java.util.*;

class Solution {
    public int solution(int[] queue1, int[] queue2) {
        int answer = 0;

        Queue<Integer> q1 = new ArrayDeque<>();
        Queue<Integer> q2 = new ArrayDeque<>();
        int cnt1 = queue1.length;
        int cnt2 = queue2.length;
        long sum1 = 0;
        long sum2 = 0;
        
        for(int q:queue1){
            sum1+=q;
            q1.add(q);
        }
        for(int q:queue2){
            sum2+=q;
            q2.add(q);
        }
        
        while(cnt1>0||cnt2>0){
            if(sum1>sum2){
                int x = q1.poll();
                cnt1--;
                q2.add(x);
                sum1-=x;
                sum2+=x;
                answer++;
            }
            else if(sum1<sum2){
                int x = q2.poll();
                cnt2--;
                q1.add(x);
                sum1+=x;
                sum2-=x;
                answer++;
            }
            if(sum1==sum2) return answer;
        }
        
        return -1;
    }
}