import java.util.*;

class Solution {
    Set<Integer> candi = new HashSet<>();
    public int solution(String numbers) {
        int answer = 0;
        
        permutation(numbers,new boolean[numbers.length()],0,0);
        
        for(int c:candi){
            if(isPrime(c)) answer++;
        }
        return answer;
    }
    
    void permutation(String numbers,boolean[] visited, int cur, int digit){
        if(digit==numbers.length()) return;
        for(int i=0;i<numbers.length();i++){
            if(!visited[i]){
                visited[i]= true;
                // int newV = cur+(int)((numbers.charAt(i)-'0')*Math.pow(10,digit));
                int newV = cur + (int)((numbers.charAt(i) - '0') * Math.pow(10, digit));
                candi.add(newV);
                permutation(numbers,visited,newV,digit+1);
                visited[i] = false;
            }
        }
    }
    
    // boolean isPrime(int n){
    //     if(n<2) return false;
    //     if(n%2==0 || n%3==0) return false;
    //     int sq = (int)Math.sqrt(n);
    //     for(int i=4;i<=sq;i++){
    //         if(n%i==0) return false;
    //     }
    //     return true;
    // }
    boolean isPrime(int n) {
        if (n < 2) return false;
        
        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) return false;
        }
        
        return true;
    }
}