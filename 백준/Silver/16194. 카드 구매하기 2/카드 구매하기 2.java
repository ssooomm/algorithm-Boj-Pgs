import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int[] arr= new int[n+1];
        for(int i=1;i<=n;i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        
        for(int i=2;i<=n;i++){
            for(int j=1;j<=i/2;j++){
                int x = arr[j]+arr[i-j];
                arr[i] = Math.min(x,arr[i]);
            }
        }
        System.out.println(arr[n]);
    }
}