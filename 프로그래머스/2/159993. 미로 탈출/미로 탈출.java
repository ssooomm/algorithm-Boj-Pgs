import java.util.*;

class Solution {
    int[] dr = {0,0,1,-1};
    int[] dc = {1,-1,0,0};
    
    public int solution(String[] maps) {
        int answer = 0;
        int n = maps.length;
        int m = maps[0].length();
        
        Queue<int[]> q = new ArrayDeque<>();
        boolean[][] visited = new boolean[n][m];
        
        for(int r=0;r<n;r++){
            for(int c=0;c<m;c++){
                if(maps[r].charAt(c)=='S'){
                    q.add(new int[]{r,c,0});
                    visited[r][c] = true;
                }
            }
        }
        
        int toL = 0, toLR=0, toLC=0;
        while(!q.isEmpty()){
            int[] cur = q.remove();
            int r = cur[0];
            int c= cur[1];
            int d = cur[2];
            if(maps[r].charAt(c)=='L'){
                toL += d;
                toLR = r;
                toLC = c;
                break;
            }
            for(int i=0;i<4;i++){
                int nr = r+dr[i];
                int nc = c+dc[i];
                if(nr>=0&&nr<n&&nc>=0&&nc<m&&!visited[nr][nc]&&maps[nr].charAt(nc)!='X'){
                    visited[nr][nc] = true;
                    q.add(new int[]{nr,nc,d+1});
                }
            }
        }
        if(toL==0) return -1;
        
        q = new ArrayDeque<>();
        visited = new boolean[n][m];
        q.add(new int[]{toLR,toLC,0});
        visited[toLR][toLC] = true;
        
        int toE=0;
        while(!q.isEmpty()){
            int[] cur = q.remove();
            int r = cur[0];
            int c= cur[1];
            int d = cur[2];
            if(maps[r].charAt(c)=='E'){
                toE += d;
                break;
            }
            for(int i=0;i<4;i++){
                int nr = r+dr[i];
                int nc = c+dc[i];
                if(nr>=0&&nr<n&&nc>=0&&nc<m&&!visited[nr][nc]&&maps[nr].charAt(nc)!='X'){
                    visited[nr][nc] = true;
                    q.add(new int[]{nr,nc,d+1});
                }
            }
        }
        if(toE==0) return -1;
        
        return toL+toE;
    }
}