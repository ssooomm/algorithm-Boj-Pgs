import java.util.*;

class Solution {
    static int[] dx = {1,-1,0,0};
    static int[] dy = {0,0,1,-1};
    static int answer=0,r,c;
    static char[][] map;
    static boolean[][] v;
    
    public int solution(String[] maps) {
        r = maps.length;
        c = maps[0].length();
        map = new char[r][c];
        v = new boolean[r][c];
        
        int[] s = new int[2];
        int[] l = new int[2];
        int[] e = new int[2];
        
        for(int i=0;i<r;i++){
            for(int j=0;j<c;j++){
                map[i][j] = maps[i].charAt(j);
                if(map[i][j]=='S'){
                    s[0] = i;
                    s[1] = j;
                }
                else if(map[i][j]=='L'){
                    l[0] = i;
                    l[1] = j;
                }
                else if(map[i][j]=='E'){
                    e[0] = i;
                    e[1] = j;
                }
            }
        }
        
        int cnt = bfs(s,l);
        if(cnt==-1) return -1;
        else answer+=cnt;
        
        v = new boolean[r][c];
        cnt=bfs(l,e);
        if(cnt==-1) return -1;
        else answer+=cnt;
        
        return answer;
    }
    
    int bfs(int[] st, int[] end){
        Queue<int[]> q = new ArrayDeque<>();
        q.add(new int[]{st[0],st[1],0});
        v[st[0]][st[1]] = true;
        
        while(!q.isEmpty()){
            int[] cur = q.poll();
            if(cur[0]==end[0]&&cur[1]==end[1]){
                return cur[2];
            }
            for(int i=0;i<4;i++){
                int nx = cur[0]+dx[i];
                int ny = cur[1]+dy[i];
                if(nx<0||nx>=r||ny<0||ny>=c) continue;
                if(map[nx][ny]!='X'&&!v[nx][ny]){
                    v[nx][ny] = true;
                    q.add(new int[]{nx,ny,cur[2]+1});
                }
            }
        }
        return -1;
    }
}