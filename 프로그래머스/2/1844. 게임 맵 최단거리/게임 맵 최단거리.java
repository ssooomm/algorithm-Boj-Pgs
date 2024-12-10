import java.util.*;

class Solution {
    int[] dr = {0,0,1,-1};
    int[] dc = {1,-1,0,0};
    
    public int solution(int[][] maps) {
        int answer = -1;
        int n = maps.length;
        int m = maps[0].length;
        boolean[][] visited = new boolean[n][m];
        
        Queue<int[]> q = new ArrayDeque<>();
        q.add(new int[]{0,0,1});
        visited[0][0] = true;
        
        while(!q.isEmpty()){
            int[] curr = q.remove();
            if(curr[0]==n-1 && curr[1]==m-1) return curr[2];
            for(int i=0;i<4;i++){
                int nr = curr[0] + dr[i];
                int nc = curr[1] + dc[i];
                
                if(nr>=0 && nr<n && nc>=0 && nc<m){
                    if(maps[nr][nc]==1 && !visited[nr][nc]){
                        q.add(new int[]{nr,nc, curr[2]+1});
                        visited[nr][nc] = true;
                    }
                }
            }
        }
        return answer;
    }
}