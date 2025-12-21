import java.util.*;

public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int v = sc.nextInt();
        int n = sc.nextInt();
        long[] dp = new long[n+1];
        dp[0] = 1;
        for(int i=0;i<v;i++){
            int x = sc.nextInt();
            if(x>n) continue;
            for(int j=x;j<=n;j++){
                dp[j] = dp[j]+dp[j-x];
            }
        }
        System.out.println(dp[n]);
    }
}
