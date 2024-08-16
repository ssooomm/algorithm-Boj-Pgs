import java.util.*;

class Solution {
    public int solution(int[] array) {
        int answer = 0;
        Arrays.sort(array);
        int max = array[array.length-1];
        int[] recur = new int[max+1];
        for(int i=0;i<array.length;i++){
            int n = array[i];
            recur[n]++;
        }
        
        int maxx = 0, idx = 0;
        for(int i=0;i<recur.length;i++){
            if(maxx<recur[i]){
                maxx = recur[i];
                idx = i;
            }
            else if(maxx==recur[i]){
                idx = -1;
            }
        }
        return idx;
    }
}