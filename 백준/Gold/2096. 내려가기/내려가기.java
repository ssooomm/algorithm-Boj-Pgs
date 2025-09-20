import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st;
        int[][] arr = new int[n+1][3];
        for(int i=1;i<=n;i++){
            st=new StringTokenizer(br.readLine());
            for(int j=0;j<3;j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int[][] dp = new int[n+1][3];
        int[][] dp2 = new int[n+1][3];
        
        for(int i=0;i<3;i++){
            dp[1][i] = arr[1][i];
            dp2[1][i] = arr[1][i];
        }
        
        for(int i=2;i<=n;i++){
            int f = Math.max(dp[i-1][0],dp[i-1][1]);
            int s = Math.max(f,dp[i-1][2]);
            int t = Math.max(dp[i-1][1],dp[i-1][2]);
            dp[i][0] = f+arr[i][0];
            dp[i][1] = s+arr[i][1];
            dp[i][2] = t+arr[i][2];

            f = Math.min(dp2[i-1][0],dp2[i-1][1]);
            s = Math.min(f,dp2[i-1][2]);
            t = Math.min(dp2[i-1][1],dp2[i-1][2]);
            dp2[i][0] = f+arr[i][0];
            dp2[i][1] = s+arr[i][1];
            dp2[i][2] = t+arr[i][2];
            
        }
        
        System.out.print(Math.max(Math.max(dp[n][0],dp[n][1]),dp[n][2])+" ");
        System.out.print(Math.min(Math.min(dp2[n][0],dp2[n][1]),dp2[n][2]));
    }
}