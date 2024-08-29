class Solution {
    public int solution(int n, int[][] computers) {
        int answer = 0;
        boolean[] visited = new boolean[n];
        for(int i=0;i<n;i++){
            if(!visited[i]){
                dfs(computers,visited,i,n);
                answer++;
            }
        }
        
        return answer;
    }
    
    void dfs(int[][] computers, boolean[] visited,int cur, int n){
        visited[cur] = true;
        for(int col=0;col<n;col++){
            if(!visited[col]){
                if(computers[cur][col]==1){
                    dfs(computers,visited,col,n);
                }
            }
        }
    }
}