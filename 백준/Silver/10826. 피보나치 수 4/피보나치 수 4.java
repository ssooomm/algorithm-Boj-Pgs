import java.util.*;
import java.math.BigInteger;

public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        BigInteger[] dp = new BigInteger[n+1];
        dp[0] = BigInteger.ZERO;
        if(n>=1)
            dp[1] = BigInteger.ONE;
        for(int i=2;i<=n;i++){
            dp[i] = dp[i-2].add(dp[i-1]);
        }
        System.out.println(dp[n]);
    }

}