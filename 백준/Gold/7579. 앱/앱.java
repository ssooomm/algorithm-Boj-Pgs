import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] mem = new int[n];
        int[] cost = new int[n];
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<n;i++){
            mem[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<n;i++){
            cost[i] = Integer.parseInt(st.nextToken());
        }
        
        // c<=100 비용 기준 dp
        int[][] dp = new int[n][10001];
        int res = Integer.MAX_VALUE;
        for(int i=0;i<n;i++){
            int c = cost[i];
            int mm = mem[i];
            for(int j=0;j<10001;j++){
                if(i==0){
                    if(j>=c) dp[i][j] = mm;
                }else{
                    if(j>=c){
                        dp[i][j] = Math.max(dp[i-1][j],dp[i-1][j-c]+mm);
                    }else{
                        dp[i][j] = dp[i-1][j];
                    }
                }
                if(dp[i][j]>=m){
                    res = Math.min(res,j);
                }
            }
        }
        System.out.println(res);
    }
}