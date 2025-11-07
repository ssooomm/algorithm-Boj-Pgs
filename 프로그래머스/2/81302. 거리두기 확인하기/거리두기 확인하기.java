import java.util.*;

class Solution {
    static int[] dx = {1,-1,0,0};
    static int[] dy = {0,0,1,-1};
    public int[] solution(String[][] places) {
        int[] answer = new int[5];
        
        for(int i=0;i<5;i++){
            answer[i] = check(places[i]);
        }
        return answer;
        
    }
    
    int check(String[] place){
        for(int i=0;i<5;i++){
            for(int j=0;j<5;j++){
                if(place[i].charAt(j)=='P'){
                    if(!bfs(i,j,place)) return 0;
                }
            }
        }
        return 1;
    }
    
    boolean bfs(int r, int c, String[] place){
        Queue<int[]> q = new ArrayDeque<>();
        boolean[][] v= new boolean[5][5];
        q.add(new int[]{r,c,0});
        v[r][c] = true;
        
        while(!q.isEmpty()){
            int[] cur = q.poll();
            v[cur[0]][cur[1]] = true;
            if(cur[2]>=2) continue;
            
            for(int i=0;i<4;i++){
                int nx = cur[0]+dx[i];
                int ny = cur[1]+dy[i];
                int nd = cur[2]+1;
                if(nx>=0&&nx<5&&ny>=0&&ny<5){
                    if(!v[nx][ny]&&place[nx].charAt(ny)!='X'){
                        if(place[nx].charAt(ny)=='P') return false;
                        q.add(new int[]{nx,ny,nd});
                        
                    }
                }
            }
        }
        return true;
    }
}