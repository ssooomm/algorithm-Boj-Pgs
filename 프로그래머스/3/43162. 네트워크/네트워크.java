class Solution {
    public int solution(int n, int[][] computers) {
        int answer = 0;
        boolean[] visited = new boolean[n];
        for(int r=0;r<n;r++){
            if(!visited[r]){
                dfs(r, computers, n, visited);
                answer++;
            }

        }
        return answer;
    }
    
    void dfs(int curr, int[][] computers, int n, boolean[] visited){
        visited[curr] = true;
        for(int c=0;c<n;c++){
            if(!visited[c] && computers[curr][c]==1){
                dfs(c, computers, n, visited);
            }
        }
    }
    
}