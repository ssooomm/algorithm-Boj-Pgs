import java.util.*;

class Solution {
    public int solution(int i, int j, int k) {
        int answer = 0;
        String kk = String.valueOf(k);
        for(;i<=j;i++){
            String tmp = String.valueOf(i);
            String[] arr = tmp.split("");
            for(String s:arr){
                if(s.equals(kk)) answer++;
            }
        }
        return answer;
    }
}