import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[] arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<n;i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        
        int bef=0;
        for(int i=0;i<k;i++){
            bef+=arr[i];
        }
        int max = bef;
        for(int i=0;i<n-k;i++){
            bef-=arr[i]-arr[i+k];
            max = Math.max(bef,max);
        }
        System.out.println(max);
    }
}