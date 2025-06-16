import java.util.*;
import java.io.*;

public class Main{
    static int[] dx = {1,-1,0,0};
    static int[] dy = {0,0,1,-1};
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        int[][] arr = new int[n][m];
        boolean[][] visited = new boolean[n][m];
        boolean flag = false;
        Queue<int[]> q = new ArrayDeque<>();
        for(int i=0;i<n;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<m;j++){
                int x = Integer.parseInt(st.nextToken());
                arr[i][j] = x;
                if(x==1){
                    q.add(new int[]{i,j,0});
                    visited[i][j] = true;
                }
                else if(x==0) flag = true;
            }
        }
        if(!flag){
            System.out.println(0);
            return;
        }
        
        int max=0;
        while(!q.isEmpty()){
            int[] cur = q.poll();
            for(int i=0;i<4;i++){
                int nx = dx[i]+cur[0];
                int ny = dy[i]+cur[1];
                if(nx>=0&&nx<n&&ny>=0&&ny<m){
                    if(!visited[nx][ny]&&arr[nx][ny]!=-1){
                        arr[nx][ny] = cur[2]+1;
                        visited[nx][ny] = true;
                        q.add(new int[]{nx,ny,cur[2]+1});
                        max=cur[2]+1;
                    }
                }
            }
        }
        
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(arr[i][j]==0){
                    System.out.println(-1);
                    return;
                }
            }
        }
        System.out.println(max);
    }
}