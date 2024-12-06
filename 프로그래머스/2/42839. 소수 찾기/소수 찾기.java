import java.util.*;

class Solution {
    public int solution(String numbers) {
        String[] arr = numbers.split("");

        Set<Integer> hs = new HashSet<>();
        boolean[] visited = new boolean[arr.length];
        
        for(int i=1;i<=arr.length;i++){
            backtrack(new ArrayList<>(), hs, i, arr,visited);
        }
        return hs.size();
    }
    public void backtrack(List<String> curr, Set<Integer> ans, int digits, String[] arr, boolean[] visited){
        if(curr.size()==digits){
            int n = Integer.parseInt(String.join("",curr));
            if(isPrime(n)){
                ans.add(n);
            }
                
            return;
        }
        
        for(int i=0;i<arr.length;i++){
            if(!visited[i]){
                visited[i] = true;
                curr.add(arr[i]);
                backtrack(curr, ans, digits, arr,visited);
                visited[i] = false;
                curr.remove(curr.size()-1);
            }
            
            
        }
    }
    public boolean isPrime(int n){
        if(n<=1) return false;
        if(n==2) return true;
        if(n%2==0) return false;
        int tmp = (int)Math.sqrt(n);
        for(int i=3;i<=tmp;i+=2){
            if(n%i==0) return false;
        }
        return true;
    }
}