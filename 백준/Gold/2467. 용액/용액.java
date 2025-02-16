import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int[] arr = new int[n];
        for(int i=0;i<n;i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        
        int min = Integer.MAX_VALUE;
        int ml=0,mr=0;
        for(int i=0;i<n-1;i++){
            int l = i+1;
            int r = n-1;
            while(l<=r){
                int mid = (l+r)/2;
                int sum = Math.abs(arr[i]+arr[mid]);
                
                if(min>sum){
                    min = sum;
                    ml = i;
                    mr = mid;
                }
                if(arr[mid]>=-arr[i]){
                    r = mid-1;
                }else{
                    l = mid+1;
                }
            }
        }
        System.out.println(arr[ml]+" "+arr[mr]);
    }
}