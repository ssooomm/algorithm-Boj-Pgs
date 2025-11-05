import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] l = new int[n];
        int[] j = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0;i<n;i++){
            l[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<n;i++){
            j[i] = Integer.parseInt(st.nextToken());
        }
        
        int[] dp = new int[100];
        for(int x=0;x<n;x++){
            int ll = l[x];
            int jj = j[x];
            for(int y=99;y>=ll;y--){
                dp[y] = Math.max(dp[y],dp[y-ll]+jj);
            }
        }
        
        int max=dp[0];
        for(int i=1;i<100;i++){
            max = Math.max(max,dp[i]);
        }
        System.out.println(max);
    }
}