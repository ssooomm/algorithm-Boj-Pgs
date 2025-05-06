import java.util.*;

public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        
        int[][] dp = new int[n+1][10];
        Arrays.fill(dp[0],1);
        
        for(int i=1;i<=n;i++){
            dp[i][9] = 1;
            for(int j=8;j>=0;j--){
                dp[i][j] = (dp[i-1][j]+dp[i][j+1])%10007;
            }
        }
        System.out.println(dp[n][0]);
    }
}