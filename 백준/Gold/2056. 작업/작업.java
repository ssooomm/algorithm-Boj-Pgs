import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n+1];
        int res=0;
        for(int i=1;i<=n;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int t = Integer.parseInt(st.nextToken());
            int num = Integer.parseInt(st.nextToken());
            if(num==0){
                arr[i] = t;
            }else{
                int max=0;
                while(num-->0){
                    int tmp = Integer.parseInt(st.nextToken());
                    max = Math.max(arr[tmp],max);
                }
                arr[i] = max+t;
            }
            res = Math.max(res,arr[i]);
        }
        System.out.println(res);
    }
}