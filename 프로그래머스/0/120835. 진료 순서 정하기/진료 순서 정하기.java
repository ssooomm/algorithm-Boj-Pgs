import java.util.*;

class Solution {
    public int[] solution(int[] emergency) {
        int len = emergency.length;
        int[] answer = new int[len];
        int[] copy = Arrays.copyOf(emergency,len);
        Arrays.sort(copy);
        for(int i=0;i<len;i++){
            for(int j=0;j<len;j++){
                if(emergency[j]==copy[i]){
                    answer[j] = len-i;
                }
            }
        }
        return answer;
    }
}