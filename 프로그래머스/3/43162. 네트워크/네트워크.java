class Solution {
    public int solution(int n, int[][] computers) {
        int answer = 0;
        
        boolean[] visited = new boolean[n];
        for(int row=0;row<n;row++){
            if(!visited[row]){
                dfs(visited,computers,row,n);
                answer++;
            }
        }
        return answer;
    }
    
    void dfs(boolean[] visited, int[][] computers, int cur, int n){
        visited[cur] = true;
        for(int col=0;col<n;col++){
            if(!visited[col]&&computers[cur][col]==1){
                dfs(visited,computers,col,n);
            }
        }
    }
}