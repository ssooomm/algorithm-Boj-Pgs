import java.util.*;

class Solution {
    public int solution(int[] numbers, int target) {
        
        
        
        
        return dfs(0,0,numbers,target);
    }
    
    int dfs(int curr, int idx, int[] numbers, int target){
        if(idx==numbers.length){
            if(curr==target){
                return 1;
            }
            return 0;
        }
        
        int cnt=0;
        cnt += dfs(curr+numbers[idx], idx+1, numbers,target);
        cnt += dfs(curr-numbers[idx], idx+1, numbers,target);
        return cnt;
    }
}