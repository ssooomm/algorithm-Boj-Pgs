import java.util.*;

class Solution {
    Set<Integer> hs = new HashSet<>();
    public int solution(String numbers) {
        int answer = 0;
        perm(numbers, new boolean[numbers.length()],0,0);
        for(Integer n:hs){
            System.out.println(n);
            if(isPrime(n)) answer++;
        }
        return answer;
    }
    void perm(String numbers, boolean[] visited, int curr, int digits){
        if(digits==numbers.length()) return;
        
        for(int i=0;i<numbers.length();i++){
            if(!visited[i]){
                int newVal = curr+(int)((numbers.charAt(i)-'0')*Math.pow(10,digits));
            hs.add(newVal);
            
            visited[i] = true;
            perm(numbers,visited,newVal,digits+1);
            visited[i] = false;
            }
            
        }
    }
    
    boolean isPrime(int n){
        if(n<2) return false;
        int tmp = (int)Math.sqrt(n);
        for(int i=2;i<=tmp;i++){
            if(n%i==0) return false;
        }
        return true;
    }
}