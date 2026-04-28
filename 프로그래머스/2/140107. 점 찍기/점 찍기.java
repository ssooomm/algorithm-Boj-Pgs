import java.util.*;

class Solution {
    public long solution(int k, int d) {
        long answer = 0;
        
        long dd = (long) d*d;
        
        for(long x=0;x<=d;x+=k){
            long y = (long)Math.sqrt(dd - (x*x));
            answer+=(y/k)+1; //k개 차이로 나올 수 있는 y값 개수 + 0값
        }

        return answer;
    }
}