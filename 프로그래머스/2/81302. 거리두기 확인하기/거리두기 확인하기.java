import java.util.*;

class Solution {
    int m = 5;
    int[] dr = {1,-1,0,0};
    int[] dc = {0,0,1,-1};
    public int[] solution(String[][] places) {
        int[] answer = new int[m];
        for(int i=0;i<m;i++){
            if(check(places[i])) answer[i] = 1;
        }
        return answer;
    }
    
    boolean check(String[] place){
        for(int r=0;r<m;r++){
            for(int c=0;c<m;c++){
                if(place[r].charAt(c)=='P'){
                    if(!bfs(r,c,place))  
                        return false;
                }
            } 
        }
        return true;
    }
    
    boolean bfs(int r, int c, String[] place){
        boolean[][] visited = new boolean[m][m];
        Queue<int[]> q = new ArrayDeque<>();
        q.add(new int[]{r,c,0});
        visited[r][c] = true;
        
        while(!q.isEmpty()){
            int[] cur = q.remove();
            int row = cur[0];
            int col = cur[1];
            int d = cur[2];
            for(int i=0;i<4;i++){
                int nr = row+dr[i];
                int nc = col+dc[i];
                int nd = d+1;
                if(nr>=0&&nr<m&&nc>=0&&nc<m){
                    if(!visited[nr][nc] && place[nr].charAt(nc) !='X'){
                        if(nd>2) continue;
                        //거리가 2이하인데 응시자 있으면 
                        if(place[nr].charAt(nc)=='P') return false;
                        q.add(new int[]{nr,nc,nd});
                        visited[nr][nc] = true;
                    }
                }
            }
        }
        
        //bfs완료는 거리두기 준수
        return true;
    }
}