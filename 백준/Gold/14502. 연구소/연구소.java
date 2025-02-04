import java.io.*;
import java.util.*;

public class Main{
    static int[] dx = {1,-1,0,0};
    static int[] dy = {0,0,1,-1};
    static int[][] map;
    static int n,m;
    static int maxCnt = 0;
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n][m];
        
        for(int i=0;i<n;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<m;j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        dfs(0);
        
        System.out.println(maxCnt);
    }
    
    static void dfs(int wallCnt){
        //벽 3개 설치되면 bfs 진행
        if(wallCnt == 3){
            bfs();
            return;
        }
        
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(map[i][j]==0){ //빈칸이면
                    map[i][j] = 1; //벽 세우기
                    dfs(wallCnt+1);
                    map[i][j] = 0;
                }
            }
        }
    }
    
    static void bfs(){
        Queue<int[]> q = new ArrayDeque<>();
        
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(map[i][j]==2){ //바이러스 퍼질 곳
                    q.add(new int[]{i,j});
                }
            }
        }
        
        //원본 map 바꾸지 않고 카피
        int[][] copyMap = new int[n][m];
        for(int i=0;i<n;i++){
            copyMap[i] = map[i].clone();
        }
        
        //바이러스 퍼트리기
        while(!q.isEmpty()){
            int[] tmp = q.poll();
            for(int i=0;i<4;i++){
                int nx = tmp[0] + dx[i];
                int ny = tmp[1] + dy[i];
                
                if(nx>=0&&ny>=0&&nx<n&&ny<m){
                    if(copyMap[nx][ny]==0){
                        copyMap[nx][ny] = 2;
                        q.add(new int[]{nx,ny});
                    }
                }
            }
        }
        
        cntSafe(copyMap);
    }
    
    static void cntSafe(int[][] copyMap){
        int cnt = 0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(copyMap[i][j]==0) cnt++;
            }
        }
        
        maxCnt = Math.max(maxCnt, cnt); 
    }
}