import java.util.*;

class Solution {
    public int solution(int[][] lines) {
        int answer = 0;
        Map<Integer,Integer> tmp = new HashMap<>();
        for(int[] l:lines){
            for(int i=l[0];i<l[1];i++){
                tmp.put(i,tmp.getOrDefault(i,0)+1);
            }
        }
        for(int x:tmp.values()){
            if(x>1) answer++;
        }
        return answer;
    }
}