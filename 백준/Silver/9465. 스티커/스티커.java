import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while(t-->0){
            int n = Integer.parseInt(br.readLine());
            StringTokenizer st;
            int[][] arr = new int[2][n+1];
            for(int i=0;i<2;i++){
                st = new StringTokenizer(br.readLine());
                for(int j=1;j<=n;j++){
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            int[][] dp = new int[2][n+1];
            for(int i=1;i<=n;i++){
                dp[0][i] = arr[0][i]+ dp[1][i-1];
                dp[1][i] = arr[1][i]+ dp[0][i-1];
                
                if(i>=3){
                    dp[0][i] = Math.max(dp[1][i-2]+arr[0][i],dp[0][i]);
                    dp[1][i] = Math.max(dp[0][i-2]+arr[1][i],dp[1][i]);
                }
            }
            System.out.println(Math.max(dp[0][n],dp[1][n]));
        }
    }
}