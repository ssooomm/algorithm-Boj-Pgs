import java.util.*;
import java.io.*;

public class Main{
    static int[] dx = {1,-1,0,0};
    static int[] dy = {0,0,1,-1};
    static int r,c,cheese=0,prev=0,time=0;
    static int[][] map;
    static boolean[][] v;
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        map = new int[r][c];
        for(int i=0;i<r;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<c;j++){
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j]==1) cheese++;
            }
        }
        
        while(cheese>0){
            bfs();
            melt();
        }
        
        System.out.println(time);
        System.out.println(prev);
        
    }
    
    static void bfs(){
        v = new boolean[r][c];
        Queue<int[]> q = new ArrayDeque<>();
        q.add(new int[]{0,0});
        v[0][0] = true;
        while(!q.isEmpty()){
            int[] cur = q.poll();
            for(int i=0;i<4;i++){
                int nx = dx[i]+cur[0];
                int ny = dy[i]+cur[1];
                if(nx>=0&&nx<c&&ny>=0&&ny<r){
                    if(!v[ny][nx]&&map[ny][nx]==0){
                        v[ny][nx] = true;
                        q.add(new int[]{nx,ny});
                    }
                }
            }
        }
    }
    
    static void melt(){
        Queue<int[]> q = new ArrayDeque<>();
        for(int i=0;i<r;i++){
            for(int j=0;j<c;j++){
                if(map[i][j]==1){
                    for(int z=0;z<4;z++){
                        int nx = dx[z]+j;
                        int ny = dy[z]+i;
                        if(nx>=0 && nx < c && ny >=0 && ny < r){
                            if(v[ny][nx]){
                                q.add(new int[]{j,i});
                                break;
                            }
                        }
                    }
                }
            }
        }
        
        prev = cheese;
        cheese-=q.size();
        while(!q.isEmpty()){
            int[] cur = q.poll();
            map[cur[1]][cur[0]] = 0;
        }
        time++;
    }
}