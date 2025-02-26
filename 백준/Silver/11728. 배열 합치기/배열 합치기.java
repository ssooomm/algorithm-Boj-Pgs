import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] a = new int[n];
        int[] b = new int[m];
        
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<n;i++){
            a[i] = Integer.parseInt(st.nextToken());
        }
        
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<m;i++){
            b[i] = Integer.parseInt(st.nextToken());
        }
        
        StringBuilder sb = new StringBuilder();
        int idx = 0, x=0, y=0;
        while(true){
            if(a[x]<b[y]){
                sb.append(a[x++]+" ");
            }
            else{
                sb.append(b[y++]+" ");
            }
            if(x==n){
                for(int i=y;i<m;i++){
                    sb.append(b[i]+" ");
                }
                break;
            }
            if(y==m){
                for(int i=x;i<n;i++){
                    sb.append(a[i]+" ");
                }
                break;
            }
        }
        
        System.out.println(sb);
    }
}