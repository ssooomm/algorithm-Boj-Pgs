import java.util.*;

class Solution {
    public int solution(int[][] targets) {
        int answer = 0;
        Arrays.sort(targets,(a,b)->Integer.compare(a[1],b[1]));
        
        int p=0;
        for(int[] t:targets){
            if(t[0]>=p){
                answer++;
                p = t[1];
            }
        }
        return answer;
    }
}