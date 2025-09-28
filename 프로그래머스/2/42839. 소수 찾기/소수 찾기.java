import java.util.*;

class Solution {
    static Set<Integer> set = new HashSet<>();
    static String[] arr;
    static boolean[] visited;
    public int solution(String numbers) {
        int answer = 0;
        arr=numbers.split("");
        visited = new boolean[numbers.length()];
        
        for(int i=1;i<=numbers.length();i++){
            bt(i,"");
        }
        for(int x:set){
            if(isPrime(x)) answer++;
        }
        return answer;
    }
    
    static void bt(int depth, String str){
        if(str.length()==depth){
            set.add(Integer.parseInt(str));
        }
        for(int i=0;i<arr.length;i++){
            if(!visited[i]){
                visited[i] = true;
                bt(depth,str+arr[i]);
                visited[i] = false;
            }
        }
    }
    
    static boolean isPrime(int n){
        if(n==0||n==1) return false;
        int sq = (int)Math.sqrt(n);
        for(int i=2;i<=sq;i++){
            if(n%i==0) return false;
        }
        return true;
    }
}