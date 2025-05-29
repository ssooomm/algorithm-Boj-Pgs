import java.util.*;
import java.io.*;

public class Main{
    static List<List<Integer>> graph;
    static long[] dp;
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        dp = new long[n+1];
        graph = new ArrayList<>();
        for(int i=0;i<=n;i++){
            graph.add(new ArrayList<>());
        }
        
        for(int i=2;i<=n;i++){
            st = new StringTokenizer(br.readLine());
            char t = st.nextToken().charAt(0);
            int a = Integer.parseInt(st.nextToken());
            int p = Integer.parseInt(st.nextToken());
            
            graph.get(p).add(i);
            if(t=='W'){
                dp[i] = a*(-1);
            }
            else dp[i] = a;
        }
        
        dfs(1,-1);
        System.out.println(dp[1]);
    }
    
    static void dfs(int i, int p){
        for(int n:graph.get(i)){
            dfs(n,i);
        }
        if(p!=-1){
            if(dp[i]>0){
                dp[p]+=dp[i];
            }
        }
    }
}