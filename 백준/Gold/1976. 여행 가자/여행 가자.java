import java.util.*;
import java.io.*;

public class Main{
    static int[] parent;
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        StringTokenizer st;
        
        parent = new int[n+1];
        for(int i=0;i<=n;i++){
            parent[i] = i;
        }
        
        for(int i=1;i<=n;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=1;j<=n;j++){
                int x = Integer.parseInt(st.nextToken());
                if(x==1){
                    union(i,j);
                }
            }
        }
        st = new StringTokenizer(br.readLine());
        int start = find(Integer.parseInt(st.nextToken()));
        for(int i=1;i<m;i++){
            int next = Integer.parseInt(st.nextToken());
            if(start!=find(next)){
                System.out.println("NO");
                return;
            }
        }
        System.out.println("YES");
    }
    
    static int find(int x){
        if(x==parent[x]) return x;
        else return parent[x] = find(parent[x]);
    }
    
    static void union(int i,int j){
        i = find(i);
        j = find(j);
        if(i!=j){
            if(i<j) parent[j] = i;
            else parent[i] = j;
        }
    }
}