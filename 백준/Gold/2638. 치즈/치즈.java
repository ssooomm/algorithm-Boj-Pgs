import java.util.*;

public class Main{
    static int n,m;
    static int[] dx = {1,-1,0,0};
    static int[] dy = {0,0,1,-1};
    static int[][] map;
    static boolean[][] v;
    static int cnt;
    static List<int[]> list = new ArrayList<>();
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        map = new int[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                map[i][j] = sc.nextInt();
                if(map[i][j]==1){
                    list.add(new int[]{i,j});
                    cnt++;
                }
            }
        }
        
        int time=0;
        while(cnt!=0){
            time++;
            v=new boolean[n][m];
            dfs(0,0);
            melting();
        }
        System.out.println(time);
    }
    
    static void dfs(int x,int y){
        v[x][y] = true;
        map[x][y] = 2; //외부 공기
        
        for(int i=0;i<4;i++){
            int nx = x+dx[i];
            int ny = y+dy[i];
            
            if(nx<0||nx>=n||ny<0||ny>=m) continue;
            if(v[nx][ny]||map[nx][ny]==1) continue;
            
            dfs(nx,ny);
        }
    }
    
    static void melting(){
        for(int i=0;i<list.size();i++){
            int x = list.get(i)[0];
            int y = list.get(i)[1];
            int tmp=0;
            
            for(int j=0;j<4;j++){
                int nx = x+dx[j];
                int ny = y+dy[j];
                
                if(map[nx][ny]==2) tmp++;
            }
            if(tmp>=2){
                map[x][y] = 0;
                cnt--;
                list.remove(i);
                i--;
            }
        }
    }
}