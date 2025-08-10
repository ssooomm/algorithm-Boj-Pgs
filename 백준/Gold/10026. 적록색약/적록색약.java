import java.util.*;
import java.io.*;

public class Main{
    static int[] dx = {0,0,1,-1};
    static int[] dy = {1,-1,0,0};
    
    static int n;
    static boolean[][] visited;
    static char arr[][];
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new char[n][n];
        visited = new boolean[n][n];
        
        for(int i=0;i<n;i++){
            arr[i] = br.readLine().toCharArray();
        }
        
        int p1 = 0;
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(!visited[i][j]){
                    bfs(i,j);
                    p1++;
                }
            }
        }
        
        visited = new boolean[n][n];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(arr[i][j]=='G'){
                    arr[i][j]='R';
                }
            }
        }
        
        int p2=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(!visited[i][j]){
                    bfs(i,j);
                    p2++;
                }
            }
        }
        
        System.out.println(p1+" "+p2);
    }
    
    static void bfs(int x, int y){
        Queue<int[]> q = new ArrayDeque<>();
        q.add(new int[]{x,y});
        visited[x][y] = true;
        char color = arr[x][y];
        
        while(!q.isEmpty()){
            int[] tmp = q.poll();
            for(int i=0;i<4;i++){
                int nx = tmp[0]+dx[i];
                int ny = tmp[1]+dy[i];
                if(nx>=0&&nx<n&&ny>=0&&ny<n){
                    if(!visited[nx][ny]){
                        if(arr[nx][ny]==color){
                            visited[nx][ny] = true;
                            q.add(new int[]{nx,ny});
                        }
                    }
                }
            }
        }
    }
}