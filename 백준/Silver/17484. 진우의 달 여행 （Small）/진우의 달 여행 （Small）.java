import java.util.*;

public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] arr = new int[n][m];
        
        // 0->7시, 1->6시, 2->5시
        int[][][] dp = new int[n][m][3];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                arr[i][j] = sc.nextInt();
                Arrays.fill(dp[i][j],Integer.MAX_VALUE);
            }
        }
        for(int j=0;j<m;j++){
            dp[0][j][0] = arr[0][j];
            dp[0][j][1] = arr[0][j];
            dp[0][j][2] = arr[0][j];
        }
        
        for(int i=1;i<n;i++){
            for(int j=0;j<m;j++){
                if(j==0){ //젤 왼쪽
                    dp[i][j][0] = Math.min(dp[i-1][j+1][1],dp[i-1][j+1][2])+arr[i][j];
                    dp[i][j][1] = dp[i-1][j][0] + arr[i][j];
                } else if(j==m-1){ //젤 오른쪽
                    dp[i][j][2] = Math.min(dp[i-1][j-1][1],dp[i-1][j-1][0])+arr[i][j];
                    dp[i][j][1] = dp[i-1][j][2] + arr[i][j];
                }else{
                    dp[i][j][0] = Math.min(dp[i-1][j+1][1],dp[i-1][j+1][2])+arr[i][j];
                    dp[i][j][1] = Math.min(dp[i-1][j][0],dp[i-1][j][2])+arr[i][j];
                    dp[i][j][2] = Math.min(dp[i-1][j-1][0],dp[i-1][j-1][1])+arr[i][j];
                }
            }
        }
        
        int min = Integer.MAX_VALUE;
        for(int j=0;j<m;j++){
            for(int d=0;d<3;d++){
                min=Math.min(min,dp[n-1][j][d]);
            }
        }
        System.out.println(min);
    }
}