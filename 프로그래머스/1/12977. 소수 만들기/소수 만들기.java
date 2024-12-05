import java.util.*;

class Solution {
    public int solution(int[] nums) {
        int answer = 0;
        int len =nums.length;
        for(int i=0;i<len-2;i++){
            for(int j=i+1;j<len-1;j++){
                for(int k=j+1;k<len;k++){
                    if(isPrime(nums[i]+nums[j]+nums[k])) answer++;
                }
            }
        }
        
        return answer;
    }
    
    public boolean isPrime(int n){
        if(n<=1) return false;
        if(n==2) return true;
        if(n%2==0) return false;

        int tmp = (int)Math.sqrt(n);
        for(int i=3;i<=tmp;i+=2){
            if(n%i==0) return false;
        }
        return true;
    }
}