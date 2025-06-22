import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int h = Integer.parseInt(st.nextToken());
        
        int[] f = new int[h+1];
        int[] s = new int[h+1];
        
        for(int i=0;i<n;i++){
            int x = Integer.parseInt(br.readLine());
            if(i%2==0){
                f[h-x+1]++;
            }else{
                s[x]++;
            }
        }
        
        for (int i=h-1; i>=1; i--) {
            s[i]+=s[i+1];
        }
        for(int i=2; i<=h; i++){
            f[i]+=f[i-1];
        }
        
        
        int res = Integer.MAX_VALUE;
        int cnt = 0;
        for(int i=1;i<=h;i++){
            int tmp = f[i]+s[i];
            if(res>tmp){
                res = tmp;
                cnt = 1;
            }
            else if(res==tmp){
                cnt++;
            }
        }
        System.out.println(res+" "+cnt);
    }
}