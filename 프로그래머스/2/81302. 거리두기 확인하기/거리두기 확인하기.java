import java.util.*;

class Solution {
    int[] dr = {0,0,1,-1};
    int[] dc = {1,-1,0,0};
    public int[] solution(String[][] places) {
        int n = places.length;
        int[] answer = new int[n];
        for(int i=0;i<n;i++){
            answer[i] = check(places[i]);
        }
        return answer;
    }
    
    int check(String[] place){
        for(int r=0;r<5;r++){
            for(int c=0;c<5;c++){
                if(place[r].charAt(c)=='P'){
                    if(!bfs(r,c,place)) return 0;
                }
            }
        }
        return 1;
    }
    
    
    boolean bfs(int i, int j, String[] place){
        boolean[][] visited = new boolean[5][5];
        Queue<int[]> q = new ArrayDeque<>();
        q.add(new int[]{i,j,0});
        visited[i][j] = true;
        
        
        while(!q.isEmpty()){
            int[] curr = q.remove();
            if(curr[2]>=2) continue;
            
            for(int x=0;x<4;x++){
                int nr = curr[0] + dr[x];
                int nc = curr[1] + dc[x];
                int nd = curr[2] + 1;
                if(nr>=0&&nr<5&&nc>=0&&nc<5){
                    if(place[nr].charAt(nc) != 'X' && !visited[nr][nc]){
                        if(place[nr].charAt(nc)=='P') return false;
                        q.add(new int[]{nr,nc,nd});
                        visited[nr][nc] = true;
                    }
                }
            }
        }
        return true;
        
    }
}