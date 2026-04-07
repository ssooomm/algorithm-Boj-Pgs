import java.util.*;

class Solution {
    static int[] dx = new int[]{0,0,1,-1};
    static int[] dy = new int[]{1,-1,0,0};
    
    public int[] solution(String[][] places) {
        int[] ans = new int[5];
        for(int i=0;i<5;i++){
            if(fun(places[i])) ans[i] = 1;
        }
        return ans;
    }
    
    public boolean fun(String[] place){
        for(int j=0;j<5;j++){
            for(int k=0;k<5;k++){
                char ch = place[j].charAt(k);
                if(ch=='P'){
                    if(!bfs(place,j,k)) return false;
                }
            }
        }
        return true;
    }
    
    public boolean bfs(String[] place, int x, int y){
        boolean[][] v = new boolean[5][5];
        Queue<int[]> q = new ArrayDeque<>();
        q.add(new int[]{x,y,0});
        v[x][y] = true;
        
        while(!q.isEmpty()){
            int[] cur = q.poll();
            for(int i=0;i<4;i++){
                int nx = cur[0]+dx[i];
                int ny = cur[1]+dy[i];
                int nd = cur[2]+1;
                if(nx<0||nx>=5||ny<0||ny>=5) continue;
                char ch = place[nx].charAt(ny);
                if(!v[nx][ny]&&ch!='X'){
                    if(ch=='P'){
                        if(nd<=2) return false;
                    }
                    v[nx][ny] = true;
                    q.add(new int[]{nx,ny,nd});
                }
            }
        }
        return true;
    }
}