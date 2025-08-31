import java.util.*;

public class Main{
    static int[] dx = {1,-1,0,0};
    static int[] dy = {0,0,1,-1};
    static int cnt;
    static boolean[][] v = new boolean[12][6];
    static char[][] map = new char[12][6];
    static Queue<int[]> store = new ArrayDeque<>();
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        
        for(int i=0;i<12;i++){
            String str = sc.next();
            for(int j=0;j<6;j++){
                map[i][j] = str.charAt(j);
            }
        }
        
        while(true){
            v = new boolean[12][6];
            for(int i=11;i>=0;i--){
                for(int j=0;j<6;j++){
                    if(map[i][j]!='.'&&!v[i][j]){
                        bfs(j,i,map[i][j]);
                    }
                }
            }
            
            if(store.isEmpty()){
                System.out.println(cnt);
                return;
            }
            else bomb();
        }
    }
    
    static void bfs(int x, int y, char ch){
        Queue<int[]> q = new ArrayDeque<>();
        Queue<int[]> tmp = new ArrayDeque<>();
        q.add(new int[]{x,y});
        tmp.add(new int[]{x,y});
        v[y][x] = true;
        
        while(!q.isEmpty()){
            int[] cur = q.poll();
            for(int i=0;i<4;i++){
                int nx = cur[0]+dx[i];
                int ny = cur[1]+dy[i];
                if(nx>=0&&nx<6&&ny>=0&&ny<12){
                    if(map[ny][nx]==ch&&!v[ny][nx]){
                        v[ny][nx] = true;
                        q.add(new int[]{nx,ny});
                        tmp.add(new int[]{nx,ny});
                    }
                }
            }
        }
        
        if(tmp.size()<4) return;
        while(!tmp.isEmpty()){
            int[] cur = tmp.poll();
            store.add(cur);
        }
    }
    
    static void bomb(){
        cnt++;
        while(!store.isEmpty()){
            int[] cur = store.poll();
            int x = cur[0];
            int y = cur[1];
            map[y][x] = '.';
        }
        
        for(int i=0;i<6;i++){
            int idx=11;
            for(int j=11;j>=0;j--){
                if(map[j][i]!='.'){
                    char c = map[j][i];
                    map[j][i] = '.';
                    map[idx--][i] = c;
                }
            }
        }
        
    }
    
}