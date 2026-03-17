import java.util.*;

class Solution {
    static Set<Integer> set = new HashSet<>();
    
    public int solution(String numbers) {
        int answer = 0;
        
        String[] nums = numbers.split("");
        for(int i=1;i<=nums.length;i++){
            bt("",i,new boolean[nums.length],nums);
        }
        
        for(int num:set){
            if(prime(num)) answer++;
        }
        
        return answer;
    }
    
    void bt(String str,int n,boolean[] v,String[] nums){
        if(str.length()==n){
            set.add(Integer.parseInt(str));
            return;
        }
        for(int i=0;i<nums.length;i++){
            if(!v[i]){
                v[i] = true;
                bt(str+nums[i],n,v,nums);
                v[i]=false;
            }
        }
    }
    
    boolean prime(int x){
        if(x<2) return false;
        if(x==2) return true;
        int sq = (int)Math.sqrt(x);
        for(int i=2;i<=sq;i++){
            if(x%i==0) return false;
        }
        return true;
    }
}