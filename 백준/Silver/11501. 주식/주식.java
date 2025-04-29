import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int t = Integer.parseInt(br.readLine());
        while(t-->0){
            int n = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());
            int[] arr = new int[n];
            for(int j=0;j<n;j++){
                arr[j] = Integer.parseInt(st.nextToken());
            }
            int max = arr[n-1];
            long res = 0;
            for(int x=n-2;x>=0;x--){
                if(arr[x]<=max){
                    res+=max-arr[x];
                }else{
                    max = arr[x];
                }
            }
            System.out.println(res);
        }
    }
}