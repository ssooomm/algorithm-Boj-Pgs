import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        
        int[] arr = new int[n];
        int l=0;
        int r=0;
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<n;i++){
            arr[i] = Integer.parseInt(st.nextToken());
            r+=arr[i]; //총 합
            l = Math.max(l,arr[i]); //제일 큰 값
        }
        
        while(l<=r){
            int mid = (l+r)/2;
            int cnt = getCnt(n,arr,mid);
            
            if(cnt>m) l = mid+1; //m개 보다 적음
            else r = mid-1;
        }
        System.out.println(l);
    }
    
    static int getCnt(int n, int[] arr, int mid){
        int sum=0;
        int cnt = 0;
        for(int i=0;i<n;i++){
            if(sum+arr[i]>mid){ //중간값 보다 누적합이 커지면
                sum=0;
                cnt++;
            }
            sum+=arr[i];
        }
        if(sum!=0) cnt++;
        return cnt;
    }
}