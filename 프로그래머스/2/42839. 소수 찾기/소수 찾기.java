import java.util.*;

class Solution {
    Set<Integer> candi = new HashSet<>();
    
    public int solution(String numbers) {
        int answer = 0;

        permutation(numbers,0,0,new boolean[numbers.length()]);
        
        for(int c:candi){
            if(isPrime(c)) answer++;
        }
        return answer;
    }
    
    void permutation(String numbers,int cur, int digit, boolean[] visited){
        if(digit==numbers.length()) return;
        for(int i=0;i<numbers.length();i++){
            if(!visited[i]){
                
                int cost = cur + (int)((numbers.charAt(i)-'0')*Math.pow(10,digit));
                candi.add(cost);
                visited[i] = true;
                permutation(numbers,cost,digit+1,visited);
                visited[i] = false;
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