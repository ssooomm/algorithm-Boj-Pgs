import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        
        int[][] dp = new int[m+1][n+1];
        for(int i=1;i<=m;i++){
            st = new StringTokenizer(br.readLine());
            int d = Integer.parseInt(st.nextToken());
            int p = Integer.parseInt(st.nextToken());
            
            for(int j=1;j<=n;j++){
                dp[i][j] = dp[i-1][j];
                if(j>=d){
                    dp[i][j] = Math.max(dp[i][j],dp[i-1][j-d]+p);
                }
            }
        }
        System.out.println(dp[m][n]);
    }
}