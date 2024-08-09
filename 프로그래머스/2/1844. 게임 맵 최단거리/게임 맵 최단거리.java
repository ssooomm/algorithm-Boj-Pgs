import java.util.*;

class Solution {
    public int solution(int[][] maps) {
        int answer = -1;
        int n = maps.length;
        int m = maps[0].length;
        Queue<int[]> q = new ArrayDeque<>();
        boolean[][] visited = new boolean[n][m];
        q.add(new int[]{0,0,1});
        visited[0][0] = true;
        
        int[] dr = {0,0,1,-1};
        int[] dc = {1,-1,0,0};
        while(!q.isEmpty()){
            int[] cur = q.remove();
            int r= cur[0];
            int c = cur[1];
            int d = cur[2];
            if(r==n-1&&c==m-1) return d;
            for(int i=0;i<4;i++){
                int nr = r+dr[i];
                int nc = c+dc[i];
                if(nr>=0&&nr<n&&nc>=0&&nc<m&&!visited[nr][nc]&&maps[nr][nc]==1){
                    visited[nr][nc] = true;
                    q.add(new int[]{nr, nc, d+1});
                }
            }
        }
        return answer;
    }
}