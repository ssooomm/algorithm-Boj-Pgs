import java.util.*;

class Solution {
    static int[] dx = {1,-1,0,0};
    static int[] dy = {0,0,1,-1};
    static int[][] arr;
    static boolean[][] v;
    static int r,c;
    public int[] solution(String[] maps) {
        r = maps.length;
        c = maps[0].length();
        arr = new int[r][c];
        v = new boolean[r][c];
        
        for(int i=0;i<r;i++){
            for(int j=0;j<c;j++){
                if(maps[i].charAt(j)=='X'){
                    arr[i][j] = 0;
                    v[i][j] = true;
                }else{
                    arr[i][j] = maps[i].charAt(j)-'0';
                }
            }
        }
        
        List<Integer> list = new ArrayList<>();
        for(int i=0;i<r;i++){
            for(int j=0;j<c;j++){
                if(!v[i][j]){
                    list.add(bfs(i,j));
                }
            }
        }
        if(list.size()==0) return new int[]{-1};
        
        Collections.sort(list);
        int[] ans = new int[list.size()];
        for(int i=0;i<list.size();i++){
            ans[i] = list.get(i);
        }
        
        return ans;
    }
    
    public int bfs(int x, int y){
        Queue<int[]> q = new ArrayDeque<>();
        q.add(new int[]{x,y});
        v[x][y] = true;
        int cnt=0;
        while(!q.isEmpty()){
            int[] cur = q.poll();
            cnt+=arr[cur[0]][cur[1]];
            for(int i=0;i<4;i++){
                int nx = cur[0]+dx[i];
                int ny = cur[1]+dy[i];
                if(nx<0||nx>=r||ny<0||ny>=c) continue;
                if(!v[nx][ny]){
                    v[nx][ny] = true;
                    q.add(new int[]{nx,ny});
                }
            }
        }
        return cnt;
    }
}