import java.util.*;
import java.io.*;

public class Main{
    static int n,m;
    static int[] dx = {0,1,0,-1};
    static int[] dy = {-1,0,1,0};
    static int[][] map;
    static int cnt=0;
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());
        map = new int[n][m];
        for(int i=0;i<n;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<m;j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        move(r,c,d);
        System.out.println(cnt);
    }
    
    static void move(int y,int x, int d){
        if(map[y][x]==0){
            cnt++;
            map[y][x] = 2; //청소
        }
        
        int nd = d;
        for(int i=0;i<4;i++){
            nd = (nd+3)%4;
            int nx = x+dx[nd];
            int ny = y+dy[nd];
            if(nx>=0&&nx<m&&ny>=0&&ny<n){
                if(map[ny][nx]==0){
                    move(ny,nx,nd);
                    return;
                }
            }
        }
        
        //4칸 모두 청소 됨
        nd = (d+2)%4;
        int nx = x+dx[nd];
        int ny = y+dy[nd];
        if(nx>=0&&nx<m&&ny>=0&&ny<n){
            if(map[ny][nx]==1) return;
            move(ny,nx,d);
        }
    }
}