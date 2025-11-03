import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        for(int i=0;i<n;i++){
            arr[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(arr);
        int res=0;
        for(int i=n-1;i>=0;i-=3){
            if(i>=2){
                res+=arr[i];
                res+=arr[i-1];
                continue;
            }else if(i==1){
                res+=arr[1];
            }
            res+=arr[0];
        }
        System.out.println(res);
    }
}