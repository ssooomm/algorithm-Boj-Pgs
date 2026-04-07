import java.util.*;
import java.io.*;

public class Main{
    static int[][] dp;
    static List<Integer>[] graph;
    static int[] num;
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        num = new int[n+1];
        for(int i=1;i<=n;i++){
            num[i] = Integer.parseInt(st.nextToken());
        }
        
        graph = new ArrayList[n+1];
        for(int i=1;i<=n;i++){
            graph[i] = new ArrayList<>();
        }
        
        dp = new int[n+1][2];
        
        for(int i=0;i<n-1;i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph[a].add(b);
            graph[b].add(a);
        }
        
        dfs(1,0);
        
        System.out.println(Math.max(dp[1][0],dp[1][1]));
    }
    
    public static void dfs(int cur, int par){
        dp[cur][0] = 0;
        dp[cur][1] = num[cur];
        
        for(int i:graph[cur]){
            if(par==i) continue;
            
            dfs(i,cur);
            
            dp[cur][0] += Math.max(dp[i][0],dp[i][1]);
            dp[cur][1] += dp[i][0];
        }
    }
}