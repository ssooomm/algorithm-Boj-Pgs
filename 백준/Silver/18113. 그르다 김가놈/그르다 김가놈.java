import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        List<Integer> list = new ArrayList<>();
        int max=0;
        for(int i=0;i<n;i++){
            int l = Integer.parseInt(br.readLine());
            if(l<=k) continue;
            if(l<2*k){
                l-=k;
            }
            else{
                l-=k*2;
            }
            if(l==0) continue;
            list.add(l);
            max = Math.max(l,max);
        }
        int sta = 1;
        int end = max;
        int res=-1;
        while(sta<=end){
            int mid = (sta+end)/2;
            int cnt=0;
            for(int i:list){
                cnt+=i/mid;
            }
            if(cnt>=m){
                sta=mid+1;
                res = mid;
            }else{
                end=mid-1;
            }
        }
        
        System.out.println(res);
    }
}