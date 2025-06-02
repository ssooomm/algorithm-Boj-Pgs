import java.util.*;
import java.io.*;

public class Main{
    static List<List<int[]>> cord = new ArrayList<>();
    static int n,m;
    static int[][] arr;
    static List<Virus> v;
    static Virus[] active;
    static int empty;
    static int[] dx = {1,-1,0,0};
    static int[] dy = {0,0,1,-1};
    static int minTime = Integer.MAX_VALUE;
    static class Virus{
        int x;
        int y;
        int t;
        public Virus(int x,int y,int t){
            this.x=x;
            this.y=y;
            this.t=t;
        }
    }
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[n][n];
        v = new ArrayList<>();
        active = new Virus[m];
        
        for(int i=0;i<n;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<n;j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
                if(arr[i][j]==0) empty++;
                else if(arr[i][j]==2){
                    v.add(new Virus(i,j,0));
                }
            }
        }
        if(empty==0){
            System.out.println(0);
        }else{
            select(0,0);
            System.out.println(minTime==Integer.MAX_VALUE?-1:minTime);
        }
    }
    
    static void select(int start,int idx){
        if(idx==m){
            spread(0);
            return;
        }
        for(int i=start;i<v.size();i++){
            active[idx] = v.get(i);
            select(i+1,idx+1);
        }
    }
    
    static void spread(int cnt){
        Queue<Virus> q = new ArrayDeque<>();
        boolean[][] visited = new boolean[n][n];
        
        for(int i=0;i<m;i++){
            Virus tmp = active[i];
            q.add(tmp);
            visited[tmp.x][tmp.y] = true;
        }
        
        while(!q.isEmpty()){
            Virus cur = q.poll();
            for(int i=0;i<4;i++){
                int nx = cur.x+dx[i];
                int ny = cur.y+dy[i];
                int nt = cur.t+1;
                
                if(nx>=0&&nx<n&&ny>=0&&ny<n){
                    if(!visited[nx][ny] && arr[nx][ny]!=1){
                        // 비활성 바이러스 지나가지만, cnt는 증가x
                        if(arr[nx][ny]==0){
                            cnt++;
                            if(cnt==empty){
                                minTime = Math.min(minTime,nt);
                                return;
                            }
                        }
                        visited[nx][ny] = true;
                        q.add(new Virus(nx,ny,nt));
                    }
                }
            }
        }
    }
}