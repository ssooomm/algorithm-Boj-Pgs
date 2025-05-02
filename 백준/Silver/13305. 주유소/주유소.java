import java.util.*;
import java.io.*;

public class Main{
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args)throws IOException{
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        long[] len = new long[n-1];
        long[] cost = new long[n];
        for(int i=0;i<n-1;i++){
            len[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<n;i++){
            cost[i] = Integer.parseInt(st.nextToken());
        }
        
        long sum = 0;
        long min = Integer.MAX_VALUE;
        for(int i=0;i<n-1;i++){
            min = Math.min(min,cost[i]);
            sum+=min*len[i];
        }
        
        System.out.println(sum);
    }
}