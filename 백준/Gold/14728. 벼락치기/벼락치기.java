import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int t = Integer.parseInt(st.nextToken());
        int[][] dp = new int[n+1][t+1];
        for(int i=1;i<=n;i++){
            st = new StringTokenizer(br.readLine());
            int k = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());
            for(int j=1;j<=t;j++){
                if(j<k) dp[i][j] = dp[i-1][j];
                else dp[i][j] = Math.max(dp[i-1][j],dp[i-1][j-k]+s);
            }
        }
        
       System.out.println(dp[n][t]);
    }
}