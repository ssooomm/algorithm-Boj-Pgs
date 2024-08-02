import java.util.*;

class Solution {
    public int solution(int n) {
        int answer = 0;
        
        for(int i=4;i<=n;i++){
            if(prime(i)) answer++;
        }
        return answer;
    }
    
    boolean prime(int n){
        if(n%2==0 || n%3==0) return true;
        int s = (int)Math.sqrt(n);
        for(int i=4;i<=s;i++){
            if(n%i==0) return true;
        }
        return false;
    }
}