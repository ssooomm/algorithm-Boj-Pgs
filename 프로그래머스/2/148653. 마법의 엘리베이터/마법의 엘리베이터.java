import java.util.*;

class Solution {
    public int solution(int storey) {
        int answer = 0;
        
        String str = String.valueOf(storey);
        int len = str.length();
        
        while(len-->0){
            int num = storey%10;
            if(num>5){
                int tmp = 10-num;
                answer+=tmp;
                storey+=tmp;
            }
            else{
                answer+=num;
            }
            storey/=10;
            if(len==0&&storey==1) answer++;
        }
           
        return answer;
    }
}