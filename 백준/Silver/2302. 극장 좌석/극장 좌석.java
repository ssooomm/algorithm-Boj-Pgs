import java.util.*;

public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] arr = new int[m+2];
        arr[m+1] = n+1;
        for(int i=1;i<=m;i++){
            arr[i] = sc.nextInt();
        }
        
        int[] dp = new int[n+1];
        dp[0] = 1;
        dp[1] = 1;
        for(int i=2;i<=n;i++){
            dp[i] = dp[i-2]+dp[i-1];
        }
        
        int res=1;
        for(int i=1;i<=m+1;i++){
            int tmp = arr[i]-arr[i-1]-1;
            res*=dp[tmp];
        }
        System.out.println(res);
    }
}