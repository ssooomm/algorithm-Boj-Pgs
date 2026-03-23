import java.util.*;
import java.io.*;

public class Main{
    static int[] p;
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        
        p = new int[n+1];
        for(int i=0;i<=n;i++){
            p[i] = i;
        }
        
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<m;i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            
            if(a==0){
                union(b,c);
            }else if(a==1){
                if(find(b)==find(c)) sb.append("YES\n");
                else sb.append("NO\n");
            }
        }
        
        System.out.println(sb);
    }
    
    static int find(int a){
        if(p[a]==a) return a;
        else{
            return p[a] = find(p[a]);
        }
    }
    
    static void union(int a, int b){
        int x = find(a);
        int y = find(b);
        if(x!=y) p[y] = x; 
    }
}