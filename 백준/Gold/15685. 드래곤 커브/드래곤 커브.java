import java.util.*;
import java.io.*;;

public class Main{
    static boolean[][] grid = new boolean[101][101];
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st;
        for(int i=0;i<n;i++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            int g = Integer.parseInt(st.nextToken());

            draw(x,y,getDir(d,g));
        }

        int cnt=0;
        for(int x=0;x<100;x++){
            for(int y=0;y<100;y++){
                if(grid[x][y]&&grid[x+1][y]&&grid[x+1][y+1]&&grid[x][y+1]) cnt++;
            }
        }
        System.out.println(cnt);
    }

    static List<Integer> getDir(int d, int g){
        List<Integer> dirs = new ArrayList<>();
        dirs.add(d);
        // d는 0,1,2,3 중에
        while(g-- >0){
            for(int i=dirs.size()-1;i>=0;i--){
                // 시계방향 회전으로 0 -> 1 -> 2 -> 3 -> 0 ...
                int dir = (dirs.get(i)+1)%4;
                dirs.add(dir);
            }
        }
        return dirs;
    }

    static void draw(int x, int y, List<Integer> dirs){
        grid[x][y] = true;
        for(int d:dirs){
            if(d==0){
                grid[++x][y] = true;
            }
            else if(d==1){
                grid[x][--y] = true;
            }
            else if(d==2){
                grid[--x][y] = true;
            }
            else if(d==3){
                grid[x][++y] = true;
            }
        }
    }
}