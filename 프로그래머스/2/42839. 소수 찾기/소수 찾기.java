import java.util.*;

class Solution {
    static Set<Integer> set = new HashSet<>();
    static char[] arr;
    static boolean[] visited;
    public int solution(String numbers) {
        int answer = 0;
        arr = numbers.toCharArray();
        visited = new boolean[arr.length];
        
        backtrack(0,0);
        for(int x:set){
            if(isPrime(x)) answer++;
        }
        return answer;
    }
    
    public void backtrack(int len,int val){
        if(len==arr.length){
            return;
        }
        
        for(int i=0;i<arr.length;i++){
            if(!visited[i]){
                int newVal = val + (int)((arr[i]-'0')*Math.pow(10,len));
                set.add(newVal);
                visited[i] = true;
                backtrack(len+1,newVal);
                visited[i] = false;
            }
        }
    }
    
    public boolean isPrime(int n){
        if(n==1 || n==0) return false;
        int tmp = (int)Math.sqrt(n);
        for(int i=2;i<=tmp;i++){
            if(n%i==0) return false;
        }
        return true;
    }
}