import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int k = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        
        int[] arr = new int[k];
        for(int i=0;i<k;i++){
            arr[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(arr);
        long l = 1;
        long r = arr[k-1];
        long res = 0;
        while(l<=r){
            long mid = (l+r)/2;
            int cnt = 0;
            for(int i=0;i<k;i++){
                cnt+=arr[i]/mid;
            }
            if(cnt<n){
                r = mid-1;
            }else{
                res = mid;
                l = mid+1;
            }
        }
        System.out.println(res);
    }
}