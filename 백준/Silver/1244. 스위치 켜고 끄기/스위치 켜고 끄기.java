import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n+1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=1;i<=n;i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int t = Integer.parseInt(br.readLine());
        while(t-->0){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            if(x==1){
                for(int i=y;i<=n;i+=y){
                    arr[i] = (arr[i]==0)?1:0;
                }
            }else{
                int l=y-1,r=y+1;
                while(l>0&&r<=n){
                    if(arr[l]==arr[r]){
                        l--;
                        r++;
                    }else break;
                }
                for(int i=l+1;i<r;i++){
                    arr[i] = (arr[i]==0)?1:0;
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for(int i=1;i<=n;i++){
            sb.append(arr[i]+" ");
            if(i%20==0) sb.append("\n");
        }
        System.out.println(sb);
    }
}