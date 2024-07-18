import java.util.*;

class Solution {
    public int solution(int[] sides) {
        int answer = 0;
        int max = Arrays.stream(sides).max().getAsInt();
        int min=0;
        for(int s:sides){
            min+=s;
        }
        min-=max;
        answer = (min>max)?1:2;
        return answer;
    }
}