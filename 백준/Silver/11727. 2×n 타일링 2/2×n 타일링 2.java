import java.util.*;

public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] dp = new int[n+1];
        dp[0] = 1;
        dp[1] = 1; //n=1부터 시작, 1만 초기화 가능 
        for(int i=2;i<=n;i++){
            dp[i] = (dp[i-1] + 2*dp[i-2])%10007;
        }
        System.out.println(dp[n]);
    }
}