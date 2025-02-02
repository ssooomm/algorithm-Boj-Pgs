import java.util.*;
import java.io.*;

public class Main{
    static int[] dx = {0,0,1,-1};
    static int[] dy = {1,-1,0,0};
    
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        int[] n = new int[t];
        int[] m = new int[t];
        int[] k = new int[t];
        List<int[][]> list = new ArrayList<>();
        StringTokenizer st;
        for(int i=0;i<t;i++){
            st = new StringTokenizer(br.readLine());
            n[i] = Integer.parseInt(st.nextToken());
            m[i] = Integer.parseInt(st.nextToken());
            k[i] = Integer.parseInt(st.nextToken());
            int[][] map = new int[n[i]][m[i]];
            for(int j=0;j<k[i];j++){
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                map[x][y] = 1;
            }
            list.add(map);
        }
        
        for(int i=0;i<t;i++){
            int lenx = n[i];
            int leny = m[i];
            boolean[][] visited = new boolean[lenx][leny];
            int[][] map = list.get(i);
            int cnt = 0;
            for(int x=0;x<lenx;x++){
                for(int y=0;y<leny;y++){
                    if(map[x][y]==1 && !visited[x][y]){
                        bfs(x,y,visited,map);
                        cnt++;
                    }
                }
            }
            System.out.println(cnt);
        }
    }
    
    static void bfs(int x, int y,boolean[][] visited, int[][] map){
        Queue<int[]> q = new ArrayDeque<>();
        q.add(new int[]{x,y});
        visited[x][y] = true;
        while(!q.isEmpty()){
            int[] tmp = q.remove();
            for(int i=0;i<4;i++){
                int nx = tmp[0]+dx[i];
                int ny = tmp[1]+dy[i];
                if(nx>=0&&ny>=0&&nx<map.length&&ny<map[0].length){
                    if(map[nx][ny]==1&&!visited[nx][ny]){
                        visited[nx][ny] = true;
                        q.add(new int[]{nx,ny});
                    }
                }
            }
        }
    }
}