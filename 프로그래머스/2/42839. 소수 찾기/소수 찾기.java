import java.util.*;

class Solution {
    Set<Integer> arr = new HashSet<>();
    
    public int solution(String numbers) {
        int answer = 0;
        
        permutation(numbers, new boolean[numbers.length()], 0,0);
        
        for(int s:arr){
            if(isPrime(s)) answer++;
        }
        return answer;
    }
    
    void permutation(String numbers, boolean[] visited, int cur, int digit){
        if(digit==numbers.length()){
            return;
        }
        
        for(int i=0;i<numbers.length();i++){
            if(!visited[i]){
                visited[i] = true;
                int next = cur+(int)((numbers.charAt(i)-'0')*Math.pow(10,digit));
                arr.add(next);
                permutation(numbers, visited, next,digit+1);
                visited[i] = false;
            }
        }
    }
    
    // boolean isPrime(int num){
    //     if(num<2) return false;
    //     if(num==2 || num==3) return true;
    //     int sq = (int)Math.sqrt(num);
    //     for(int i=4;i<=sq;i++){
    //         if(num%i==0) return false;
    //     }
    //     return true;
    // }
    public boolean isPrime(int n){
        if(n<=1) return false;
        if(n==2) return true;
        if(n%2==0) return false; //짝수 걸러짐
        int sqrt = (int) Math.sqrt(n);
        for(int i=3;i<=sqrt;i+=2){ //짝수 제외, 홀수만 판별
            if(n%i==0) return false;
        }
        return true;
    }
}