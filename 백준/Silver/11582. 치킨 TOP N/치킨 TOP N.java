import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[n];
        for(int i=0;i<n;i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int k = Integer.parseInt(br.readLine());
        
        int x = n/k;
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<n;i+=x){
            int[] tmp = new int[x];
            for(int j=0;j<x;j++){
                tmp[j] = arr[i+j];
            }
            Arrays.sort(tmp);
            for(int j=0;j<x;j++){
                sb.append(tmp[j]+" ");
            }
        }
        System.out.println(sb);
    }
}