import java.util.*;
import java.io.*;

public class Main{
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args)throws IOException{
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] len = new int[n-1];
        int[] cost = new int[n];
        for(int i=0;i<n-1;i++){
            len[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<n;i++){
            cost[i] = Integer.parseInt(st.nextToken());
        }
        
        int sum = 0;
        int min = Integer.MAX_VALUE;
        for(int i=0;i<n-1;i++){
            min = Math.min(min,cost[i]);
            sum+=min*len[i];
        }
        
        System.out.println(sum);
    }
}