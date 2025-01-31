import java.util.*;
import java.io.*;

public class Main{
    static int[] dx = {0,0,1,-1};
    static int[] dy = {1,-1,0,0};
    static boolean[][] visited;
    static int[][] cnt;
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        int[][] map = new int[n][m];
        cnt = new int[n][m];
        for(int i=0;i<n;i++){
            String[] str = sc.next().split("");
            for(int j=0;j<m;j++){
                map[i][j] = Integer.parseInt(str[j]);
            }
        }

        visited = new boolean[n][m];
        bfs(0,0,n,m,map);

        System.out.println(cnt[n-1][m-1]);
    }

    static void bfs(int x,int y,int n, int m,int[][] map){
        Queue<int[]> q = new ArrayDeque<>();
        q.add(new int[]{x,y});
        visited[x][y] = true;
        cnt[x][y] = 1;

        while(!q.isEmpty()){
            int[] tmp = q.remove();
            if(tmp[0]==n-1&&tmp[1]==m-1){
                return;
            }
            for(int i=0;i<4;i++){
                int nx = tmp[0]+dx[i];
                int ny = tmp[1]+dy[i];
                if(nx>=0&&ny>=0&&nx<n&&ny<m&&!visited[nx][ny]){
                    if(map[nx][ny]==1){
                        q.add(new int[]{nx,ny});
                        visited[nx][ny] = true;
                        cnt[nx][ny] = cnt[tmp[0]][tmp[1]]+1;
                    }
                }
            }
        }
    }
}