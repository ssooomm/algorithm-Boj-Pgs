import java.util.*;
import java.io.*;

public class Main{
    static int[][] arr;
    static int[][] dp;
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        
        arr = new int[n+1][n+1];
        dp = new int[n+1][n+1];
        for(int i=1;i<=n;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=1;j<=n;j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        for(int i=1;i<=n;i++){
            for(int j=1;j<=n;j++){
                dp[i][j] = dp[i][j-1]+arr[i][j];
            }
        }
        
        StringBuilder sb = new StringBuilder();
        while(m-->0){
            st = new StringTokenizer(br.readLine());
            int[] cor = new int[4];
            for(int x=0;x<4;x++){
                cor[x] = Integer.parseInt(st.nextToken());
            }
            sb.append(add(cor)+"\n");
        }
        System.out.println(sb);
    }
    
    static int add(int[] cor){
        int res = 0;
        for(int i=cor[0];i<=cor[2];i++){
            int end = dp[i][cor[3]];
            int st = dp[i][cor[1]-1];
            res+= end-st;
        }
        return res;
    }
}