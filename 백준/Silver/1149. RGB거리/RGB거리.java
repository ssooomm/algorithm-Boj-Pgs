import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[n][3];
        int[][] dp = new int[n][3];
        StringTokenizer st;
        for(int i=0;i<n;i++){
            st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
            arr[i][2] = Integer.parseInt(st.nextToken());
        }
        dp[n-1][0] = arr[n-1][0];
        dp[n-1][1] = arr[n-1][1];
        dp[n-1][2] = arr[n-1][2];
        for(int i=n-2;i>=0;i--){
            dp[i][0] = Math.min(dp[i+1][1],dp[i+1][2])+arr[i][0];
            dp[i][1] = Math.min(dp[i+1][0],dp[i+1][2])+arr[i][1];
            dp[i][2] = Math.min(dp[i+1][1],dp[i+1][0])+arr[i][2];
        }
        int min = Math.min(dp[0][0],Math.min(dp[0][1],dp[0][2]));
        System.out.println(min);
    }
}