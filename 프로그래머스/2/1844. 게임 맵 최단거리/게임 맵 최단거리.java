import java.util.*;

class Solution {
    static int[] dx = {0,0,1,-1};
    static int[] dy = {1,-1,0,0};
    
    public int solution(int[][] maps) {
        int answer = 0;
        int n = maps.length;
        int m = maps[0].length;
        boolean[][] visited = new boolean[n][m];
        Queue<int[]> q = new ArrayDeque<>();
        q.add(new int[]{0,0,1});
        visited[0][0] = true;
        while(!q.isEmpty()){
            int[] cur = q.remove();
            if(cur[0]==n-1 && cur[1] ==m-1) return cur[2];
            for(int i=0;i<4;i++){
                int nx = cur[0] + dx[i];
                int ny = cur[1] + dy[i];
                if(nx>=0&&nx<n&&ny>=0&&ny<m){
                    if(maps[nx][ny]==1&&!visited[nx][ny]){
                        q.add(new int[]{nx,ny,cur[2]+1});
                        visited[nx][ny] = true;
                    }
                }
            }
        }
        return -1;
    }
}