import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb;
        int n = Integer.parseInt(st.nextToken());
        long[] arr = new long[n];
        int i=0;
        while(i<n){
            while(st.hasMoreTokens()){
                sb = new StringBuilder(st.nextToken());
                arr[i++] = Long.parseLong(sb.reverse().toString());
            }
            if(i==n) break;
            else{
                st = new StringTokenizer(br.readLine());
            }
        }

        Arrays.sort(arr);
        sb = new StringBuilder();
        for(int j=0;j<n;j++){
            sb.append(arr[j]+"\n");
        }
        System.out.println(sb);
    }
}
