import java.util.*;

public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] dp = new int[3][n+2];
        for(int i=1;i<=n;i++){
            dp[0][i] = sc.nextInt();
        }
        for(int i=1;i<=n;i++){
            dp[1][i] = dp[0][i]+dp[1][i-1];
        }
        for(int i=n;i>0;i--){
            dp[2][i] = dp[0][i]+dp[2][i+1];
        }
        
        long res=0;
        for(int i=2;i<n;i++){
            long tmp =(dp[1][n]*2)-dp[0][1]-dp[0][i]-dp[1][i];
            res = Math.max(res,tmp);
        }
        for(int i=n-1;i>=2;i--){
            long tmp =(dp[2][1]*2)-dp[0][n]-dp[0][i]-dp[2][i];
            res = Math.max(res,tmp);
        }
        for(int i=2;i<n;i++){
            res = Math.max(res,dp[1][i]-dp[1][1]+dp[2][i]-dp[2][n]);
        }
        System.out.println(res);
    }
}