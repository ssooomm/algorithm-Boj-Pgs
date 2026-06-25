import java.util.*;

class Solution {
    static boolean[][] visited;
    static int[][] land;
    static int[] dx = {1,-1,0,0};
    static int[] dy = {0,0,1,-1};
    static int r,c;
    static int[] dp;
    public int solution(int[][] land) {
        r = land.length;
        c = land[0].length;
        visited = new boolean[r][c];
        dp = new int[c];
        this.land = land;
        
        for(int i=0;i<r;i++){
            for(int j=0;j<c;j++){
                if(land[i][j]==1&&!visited[i][j]){
                    bfs(i,j);
                }
            }
        }
        
        int max=0;
        for(int i=0;i<c;i++){
            if(dp[i]>dp[max]){
                max=i;
            }
        }
        
        Arrays.sort(dp);
        
        return dp[c-1];
    }
    
    void bfs(int x,int y){
        Set<Integer> set = new HashSet<>();
        set.add(y);
        Queue<int[]> q = new ArrayDeque<>();
        q.add(new int[]{x,y});
        visited[x][y] = true;
        int cnt=0;
        while(!q.isEmpty()){
            int[] tmp = q.poll();
            cnt++;
            for(int i=0;i<4;i++){
                int nx = tmp[0]+dx[i];
                int ny = tmp[1]+dy[i];
                if(nx<0||ny<0||nx>=r||ny>=c) continue;
                
                if(!visited[nx][ny]&&land[nx][ny]==1){
                    visited[nx][ny] = true;
                    q.add(new int[]{nx,ny});
                    set.add(ny);
                    
                }
            }
        }
        for(int s:set){
            dp[s]+=cnt;
        }
        
    }
}