import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int[][] arr = new int[n][m];
        int[] cnt = new int[257];

        for(int i=0;i<n;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<m;j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
                cnt[arr[i][j]]++;
            }
        }
        
        int res = 0;
        int l=0,r=256;
        while(l<r){
            int rt = cnt[r]*2;
            if(cnt[l]<=rt&&cnt[l]<=b){
                res+=cnt[l];
                cnt[l+1]+=cnt[l];
                b-=cnt[l];
                l++;
            }else{
                res+=rt;
                cnt[r-1]+=cnt[r];
                b+=cnt[r];
                r--;
            }
        }
        System.out.println(res+" "+r);
    }
}