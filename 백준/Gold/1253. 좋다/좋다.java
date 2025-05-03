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
        Arrays.sort(arr);
        int ans = 0;
        for(int i=0;i<n;i++){
            int x = arr[i];
            int start = 0;
            int end = n-1;
            while(start<end){
                // 세 수가 같은 인덱스이면 안됨 
                if(start==i){
                    start++;
                    continue;
                }
                if(end==i){
                    end--;
                    continue;
                }
                
                int sum = arr[start] + arr[end];
                if(sum==x){
                    ans++;
                    break;
                }
                if(sum>x) end--;
                else start++;
            }
        }
        System.out.println(ans);
    }
}