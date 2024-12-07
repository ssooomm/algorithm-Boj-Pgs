import java.util.*;

class Solution {
    public int solution(int n, int[][] computers) {
        int answer = 0;
        boolean[] visited = new boolean[n];
        for(int r=0;r<n;r++){
            if(!visited[r]){
                dfs(visited, computers, r,n);
                answer++;
            }
        }
        return answer;
    }
    
    void dfs(boolean[] visited, int[][] computers, int curr, int n){
        visited[curr] = true;
        for(int c=0;c<n;c++){
            if(!visited[c] && computers[curr][c]==1){
                dfs(visited,computers, c,n);
            }
        }
    }
}