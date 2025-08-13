import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        Long m = Long.parseLong(st.nextToken());
        st = new StringTokenizer(br.readLine());
        Long[] arr = new Long[n];
        for(int i=0;i<n;i++){
            arr[i] = Long.parseLong(st.nextToken());
        }
        Arrays.sort(arr);
        Long l = 0L;
        Long r = arr[n-1];
        Long ans = 0L;
        while(l<=r){
            Long mid = (l+r)/2;
            Long tmp = 0L;
            for(int i=0;i<n;i++){
                if(arr[i]>mid){
                    tmp+=arr[i]-mid;
                }
            }
            if(tmp>=m){
                ans = mid;
                l=mid+1;
            }else{
                r=mid-1;
            }
        }
        System.out.println(ans);
    }
}