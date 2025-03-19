import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        while(t-->0){
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int[] arr = new int[20];
            for(int i=0;i<20;i++){
                arr[i] = Integer.parseInt(st.nextToken());
            }
            
            int cnt=0;
            for(int i=0;i<20;i++){
                for(int j=0;j<i;j++){
                    if(arr[j]>arr[i]) cnt++;
                }
            }
            sb.append(n+" "+cnt+"\n");
        }
        System.out.println(sb);
    }
}