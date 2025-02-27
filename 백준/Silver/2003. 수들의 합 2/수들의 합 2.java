import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<n;i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int cnt=0, sum=0, start=0, end=0;
        while(start<n&&end<n){
            if(sum==m){
                cnt++;
                sum-=arr[start++];
            }
            if(sum<m){
                sum+=arr[end++];
            }
            if(sum>m){
                sum-=arr[start++];
            }
        }
        for(int i=start;i<n;i++){
            if(sum==m) cnt++;
            sum-=arr[i];
        }
        System.out.println(cnt);
    }
}