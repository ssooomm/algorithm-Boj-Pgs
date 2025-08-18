import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        
        int[] arr = new int[n+1];
        int[] dp = new int[n+1];
        st = new StringTokenizer(br.readLine());
        for(int i=1;i<=n;i++){
            arr[i] = Integer.parseInt(st.nextToken());
            dp[i]+=dp[i-1]+arr[i];
        }
        
        StringBuilder sb = new StringBuilder();
        while(m-->0){
            st = new StringTokenizer(br.readLine());
            int f = Integer.parseInt(st.nextToken());
            int l = Integer.parseInt(st.nextToken());
            sb.append(dp[l]-dp[f-1]+"\n");
        }
        System.out.println(sb);
    }
}