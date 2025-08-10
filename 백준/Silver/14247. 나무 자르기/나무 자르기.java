import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st;
        int[] a = new int[n];
        Long res = 0L;
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<n;i++){
            res+=Long.parseLong(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<n;i++){
            a[i] = Integer.parseInt(st.nextToken());
        }
        
        Arrays.sort(a);
        for(int i=0;i<n;i++){
            res+=a[i]*i;
        }

        System.out.println(res);
    }
}