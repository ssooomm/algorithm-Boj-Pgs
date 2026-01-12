import java.util.*;

class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        
        int sq = (int)Math.sqrt(yellow);
        for(int i=sq;i>=1;i--){
            int x = i;
            int y = yellow/i;
            int num = (x*2)+(y*2)+4;
            if(num==brown){
                answer[0] = y+2;
                answer[1] = x+2;
                break;
            }
        }
        return answer;
    }
}