import java.util.*;

class Solution {
    int[] dx = {1,-1,0,0};
    int[] dy = {0,0,1,-1};
    public int solution(int[][] maps) {
        int answer = -1;
        int n = maps.length;
        int m = maps[0].length;
        
        Queue<int[]> q = new ArrayDeque<>();
        q.add(new int[]{0,0,1});
        boolean[][] v = new boolean[n][m];
        v[0][0] = true;
        
        while(!q.isEmpty()){
            int[] cur = q.poll();
            if(cur[0] == n-1 && cur[1] == m-1){
                return cur[2];
            }
            
            for(int i=0;i<4;i++){
                int nx = cur[0]+dx[i];
                int ny = cur[1]+dy[i];
                int nd = cur[2]+1;
                if(nx>=0&&nx<n&&ny>=0&&ny<m){
                    if(!v[nx][ny]&&maps[nx][ny]==1){
                        q.add(new int[]{nx,ny,nd});
                        v[nx][ny] = true;
                    }
                }
            }
        }
        return answer;
    }
}