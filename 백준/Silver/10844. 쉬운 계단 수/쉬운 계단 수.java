import java.util.*;

public class Main{
    static int mod = 1000000000;
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] dp = new int[n+1][10];
        
        for(int i=1;i<=9;i++){
            dp[1][i] = 1;
        }
        
        for(int i=2;i<=n;i++){
            for(int j=0;j<=9;j++){
                if(j==0) dp[i][j] = dp[i-1][j+1]%mod;
                else if(j==9) dp[i][j] = dp[i-1][j-1]%mod;
                else{
                    dp[i][j] = (dp[i-1][j-1]+dp[i-1][j+1])%mod;
                }
            }
        }
        
        int res=0;
        for(int x:dp[n]){
            res=(res+x)%mod;
        }
        System.out.println(res);
    }
}