import java.util.*;

class Solution {
    static Set<Integer> hs = new HashSet<>();
    static boolean[] v;
    public int solution(String numbers) {
        int answer = 0;
        String[] arr = numbers.split("");
        v = new boolean[arr.length];
        for(int i=1;i<=arr.length;i++){
            bt(i,"",arr);
        }
        
        for(int i:hs){
            if(isPrime(i)) answer++;
        }
        return answer;
        
    }
    
    void bt(int len,String str,String[] arr){
        if(str.length()==len){
            hs.add(Integer.parseInt(str));
            return;
        }
        
        for(int i=0;i<arr.length;i++){
            if(!v[i]){
                v[i] = true;
                bt(len,str+arr[i],arr);
                v[i] = false;
            }
        }
    }
    
    boolean isPrime(int n){
        if(n<2) return false;
        int sq = (int)Math.sqrt(n);
        
        for(int i=2;i<=sq;i++){
            if(n%i==0) return false;
        }
        return true;
    }
}