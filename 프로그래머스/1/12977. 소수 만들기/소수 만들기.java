import java.util.*;

class Solution {
    static int sum=0;
    static int answer=0;
    public int solution(int[] nums) {

        bt(nums,0,0);

        return answer;
    }
    
    void bt(int[] nums,int cnt,int st){
        if(cnt==3){
            if(isPrime(sum)) answer++;
            return;
        }
        
        for(int i=st;i<nums.length;i++){
            sum+=nums[i];
            bt(nums,cnt+1,i+1);
            sum-=nums[i];
        }
    }
    
    boolean isPrime(int n){
        if(n<2) return false;
        int sq = (int) Math.sqrt(n);
        for(int i=2;i<=sq;i++){
            if(n%i==0) return false;
        }
        return true;
    }
}