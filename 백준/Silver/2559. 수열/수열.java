import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[] arr = new int[n];
        st = new StringTokenizer(br.readLine());
        int sum =0;
        for(int i=0;i<n;i++){
            arr[i] = Integer.parseInt(st.nextToken());
            if(i<k) sum+=arr[i];
        }
        int max = sum;
        for(int i=k;i<n;i++){
            sum+=arr[i]-arr[i-k];
            max = Math.max(sum,max);
        }
        System.out.println(max);
    }
}