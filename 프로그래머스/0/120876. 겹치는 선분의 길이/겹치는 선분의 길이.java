import java.util.*;

class Solution {
    public int solution(int[][] lines) {
        int answer = 0;
        Map<Integer,Integer> map = new HashMap<>();
        for(int[] l:lines){
            for(int i=l[0];i<l[1];i++){
                map.put(i,map.getOrDefault(i,0)+1);
            }
        }
        
        for(int n:map.values()){
            if(n>=2) answer++;
        }
        return answer;
    }
}