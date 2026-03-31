import java.util.*;

class Solution {
    public int solution(int[] players, int m, int k) {
        int answer = 0;
        
        int s=0;
        Queue<Integer> time = new ArrayDeque<>();
        int[] cnt = new int[24];
        
        for(int i=0;i<24;i++){
            int p = players[i];
            if(!time.isEmpty()){
                if(i-time.peek()>=k){
                    int idx = time.poll();
                    s-=cnt[idx];
                }
            }
            
            if(p>=m*(s+1)){
                int tmp = p/m;
                cnt[i] = tmp-s;
                s = tmp;
                time.add(i);
            }
            
            
        }
        
        for(int i:cnt){
            answer+=i;
        }
        
        return answer;
    }
}