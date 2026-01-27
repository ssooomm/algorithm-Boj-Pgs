import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[n+1][2];
        for(int i=0;i<n;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }
        arr[n][0] = arr[0][0];
        arr[n][1] = arr[0][1];
        
        double sum=0;
        for(int i=0;i<n;i++){
            sum+=(double)arr[i][0] * arr[i+1][1];
            sum-=(double)arr[i][1]*arr[i+1][0];
        }
        
        System.out.printf("%.1f",Math.abs(sum/2));
    }
}