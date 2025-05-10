class Solution {
    public int solution(int n, int[][] computers) {
        int answer = 0;
        
        boolean[] visited = new boolean[n];
        
        for(int i=0;i<n;i++){
            if(!visited[i]){
                dfs(i,visited,computers,n);
                answer++;
            }
        }
        
        return answer;
    }
    
    public void dfs(int i, boolean[] visited, int[][] computers, int n){
        visited[i] = true;
        for(int j=0;j<n;j++){
            if(!visited[j] && computers[i][j]==1){
                dfs(j,visited,computers,n);
            }
        }
    }
    
}