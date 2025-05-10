import java.util.*;

class Solution {
    static Set<Integer> set = new HashSet<>();
    static String[] arr;
    static boolean[] visited;
    public int solution(String numbers) {
        int answer = 0;
        arr = numbers.split("");
        visited = new boolean[arr.length];
        
        for(int i=1;i<=arr.length;i++){
            backtrack(i, "");
        }
        for(int s:set){
            if(isPrime(s)) answer++;
        }
        return answer;
    }
    
    public void backtrack(int len, String tmp){
        if(tmp.length()==len){
            set.add(Integer.parseInt(tmp));
        }
        for(int i=0;i<arr.length;i++){
            if(!visited[i]){
                visited[i] = true;
                backtrack(len,tmp+arr[i]);
                visited[i] = false;
            }
        }
    }
    
    public boolean isPrime(int n){
        if(n==0||n==1) return false;
        int sq = (int)Math.sqrt(n);
        for(int i=2;i<=sq;i++){
            if(n%i==0) return false;
        }
        return true;
    }
}