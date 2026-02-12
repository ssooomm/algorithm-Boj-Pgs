import java.util.*;

class Solution {
    static int[] dx = {1,-1,0,0};
    static int[] dy = {0,0,1,-1};
    
    public int solution(int[][] maps) {
        int n = maps.length-1;
        int m = maps[0].length-1;
        int answer = Integer.MAX_VALUE;
        boolean[][] v = new boolean[n+1][m+1];
        
        Queue<int[]> q = new ArrayDeque<>();
        q.add(new int[]{0,0,1});
        v[0][0] = true;
        
        while(!q.isEmpty()){
            int[] cur = q.poll();
            if(cur[0]==n&&cur[1]==m){
                answer = Math.min(cur[2],answer);
                continue;
            }
            for(int i=0;i<4;i++){
                int nx = cur[0]+dx[i];
                int ny = cur[1]+dy[i];
                if(nx<0||nx>n||ny<0||ny>m) continue;
                if(maps[nx][ny]==1&&!v[nx][ny]){
                    q.add(new int[]{nx,ny,cur[2]+1});
                    v[nx][ny] = true;
                }
                    
            }
        }
        return answer==Integer.MAX_VALUE?-1:answer;
    }
}