import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());
        StringTokenizer st;
        while(t-->0){
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int[] arr = new int[n];
            for(int i=0;i<n;i++){
                arr[i] = Integer.parseInt(st.nextToken());
            }
            long sum =0;
            for(int i=0;i<n-1;i++){
                for(int j=i+1;j<n;j++){
                    sum+=gcd(arr[i],arr[j]);
                }
            }
            sb.append(sum+"\n");
        }
        System.out.println(sb);
    }

    static int gcd(int a, int b){
        int r = a%b;
        if(r==0) return b;
        return gcd(b,r);
    }
}