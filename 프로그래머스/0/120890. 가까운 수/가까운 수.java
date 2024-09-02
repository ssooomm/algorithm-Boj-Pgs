import java.util.*;

class Solution {
    public int solution(int[] array, int n) {
        int answer = 0;
        int min = Integer.MAX_VALUE;
        Arrays.sort(array);
        for(int a:array){
            int tmp = Math.abs(n-a);
            if(tmp<min){
                answer = a;
                min = tmp;
            }
        }
        return answer;
    }
}