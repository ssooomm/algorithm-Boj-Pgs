import java.util.*;
import java.io.*;

public class Main{
    static int[] dx = {0,0,1,-1};
    static int[] dy = {1,-1,0,0};
    static int[][] arr;
    static int[][] dp;
    static int n;
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        StringTokenizer st;
        arr = new int[n][n];
        dp = new int[n][n];
        for(int i=0;i<n;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<n;j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        int res = 0;
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                res = Math.max(res, dfs(i,j));
            }
        }
        System.out.println(res);
    }
    
    static int dfs(int i, int j){
        //이미 dp 갱신 
        if(dp[i][j] != 0) return dp[i][j];
        
        dp[i][j] = 1; //첫 시작 1
        for(int d=0;d<4;d++){
            int nx = i+dx[d];
            int ny = j+dy[d];
            if(nx>=0&&nx<n&&ny>=0&&ny<n){
                if(arr[i][j]<arr[nx][ny]){
                    dp[i][j] = Math.max(dp[i][j],dfs(nx,ny)+1);
                }
            }
        }
        return dp[i][j];
    }
}