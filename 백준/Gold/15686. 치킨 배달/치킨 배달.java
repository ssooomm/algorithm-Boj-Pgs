import java.util.*;
import java.io.*;

public class Main{
    static int min = Integer.MAX_VALUE, n,m;
    static int[][] map;
    static List <int[]> p = new ArrayList<>();
    static List<int[]> c = new ArrayList<>();
    static boolean[] open;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n][n];

        for(int i=0;i<n;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<n;j++){
                map[i][j] = Integer.parseInt(st.nextToken());

                if(map[i][j]==1){
                    p.add(new int[]{i,j});
                }else if(map[i][j]==2){
                    c.add(new int[]{i,j});
                }
            }
        }
        open = new boolean[c.size()];
        dfs(0,0);
        System.out.println(min);
    }

    static int calc(int[] a,int[] b){
        return Math.abs(a[0]-b[0])+Math.abs(a[1]-b[1]);
    }

    static void dfs(int depth, int st){
        if(depth==m){
            int sum=0;
            for(int i=0;i<p.size();i++){
                int dist = Integer.MAX_VALUE;

                // 집과 치킨 집 거리 모두 비교
                for(int j=0;j<c.size();j++){
                    if(open[j]){
                        dist = Math.min(dist,calc(p.get(i),c.get(j)));
                    }
                }
                sum+=dist;
            }
            min = Math.min(min,sum);
            return;
        }

        for(int i=st;i<c.size();i++){
            open[i] = true;
            dfs(depth+1,i+1);
            open[i] = false;
        }
    }
}