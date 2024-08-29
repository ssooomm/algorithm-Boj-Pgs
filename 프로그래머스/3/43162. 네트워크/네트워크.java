class Solution {
    public int solution(int n, int[][] computers) {
        int answer = 0;
        boolean[] visited = new boolean[n];
        for(int row=0;row<n;row++){
            if(!visited[row]){
                dfs(computers,visited,row,n);
                answer++;
            }
        }
        return answer;
    }
    
    void dfs(int[][] computers,boolean[] visited,int cur, int n){
        visited[cur] = true;
            
        for(int col=0;col<n;col++){
            if(!visited[col]&&computers[cur][col]==1){
                visited[col] = true;
                dfs(computers,visited,col,n);
            }
        }
    }
}