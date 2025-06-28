import java.util.*;
import java.io.*;

public class Main{
    static int INF = 10001;
    static int[] arr;
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        arr = new int[n];
        int le=0,ri=0;
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<n;i++){
            arr[i] = Integer.parseInt(st.nextToken());
            ri = Math.max(ri,arr[i]);
        }

        while(le<ri){
            int mid = (le+ri)/2;
            if(solve(mid,n)<=m){
                ri = mid;
            }else{
                le = mid+1;
            }
        }
        System.out.println(ri);
        
    }
    static int solve(int mid,int n){
        int cnt=1;
        int min = INF;
        int max = 0;
        for(int i=0;i<n;i++){
            min = Math.min(min,arr[i]);
            max = Math.max(max,arr[i]);
            if(max-min>mid){ //구간 점수가 mid 보다 크면 -> 구간 나누기
                cnt++; //구간 나눈 횟수
                min = INF;
                max = 0;
                i--;
            }
        }
        return cnt;
    }
}