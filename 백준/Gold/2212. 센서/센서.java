import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int k = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0;i<n;i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        int[] dif = new int[n-1];
        for(int i=0;i<n-1;i++){
            dif[i] = arr[i+1]-arr[i];
        }
        Arrays.sort(dif);
        
        int res=0;
        for(int i=0;i<n-k;i++){
            res+=dif[i];
        }
        System.out.println(res);
    }
}