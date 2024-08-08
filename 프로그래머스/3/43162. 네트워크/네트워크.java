class Solution {
    public int solution(int n, int[][] computers) {
        int answer = 0;
        
        boolean[] visited = new boolean[n];
        
        for(int i=0;i<n;i++){
            if(!visited[i]){
                dfs(visited,computers,i,n);
                answer++;
            }
        }
        return answer;
    }
    
    void dfs(boolean[] visited, int[][] computers,int cur, int n){
        visited[cur] = true;
        
        for(int x=0;x<n;x++){
            if(!visited[x] && computers[cur][x]==1){
                dfs(visited,computers,x,n);
            }
        }
    }
}