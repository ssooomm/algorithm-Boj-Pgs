import java.util.*;
import java.io.*;

public class Main{
    static final int INF = 1000000000;
    // Integer.MAX_VALUE 사용시 오버플로우 발생 
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        int[][] arr = new int[n+1][n+1];
        StringTokenizer st;
        for(int i=1;i<=n;i++){
            for(int j=1;j<=n;j++){
                if(i==j) continue;
                arr[i][j] = INF;
            }
        }
        
        for(int i=0;i<m;i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            arr[a][b] = Math.min(arr[a][b],c);
        }
        //x가 중간 노드 
        for(int x=1;x<=n;x++){
            for(int i=1;i<=n;i++){
                for(int j=1;j<=n;j++){
                    if(i==x||j==x||i==j) continue;
                    arr[i][j] = Math.min(arr[i][j], arr[i][x]+arr[x][j]);
                }
            }
        }
        
        StringBuilder sb = new StringBuilder();
        for(int i=1;i<=n;i++){
            for(int j=1;j<=n;j++){
                if(arr[i][j]==INF) arr[i][j]=0;
                sb.append(arr[i][j]+" ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}