import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        List<Integer>[] list = new ArrayList[n+1];
        for(int i=1;i<=n;i++){
            list[i] = new ArrayList<>();
        }
        for(int i=0;i<m;i++){
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            list[u].add(v);
            list[v].add(u);
        }
        boolean[] visited = new boolean[n+1];
        int cnt =0;
        for(int i=1;i<=n;i++){
            if(!visited[i]){
                visited[i] = true;
               backtrack(list,visited,list[i]);
                cnt++;
            }
        }
        System.out.println(cnt);
    }
    
    static void backtrack(List<Integer>[] list, boolean[] visited,List<Integer> cur){
        for(int c:cur){
            if(!visited[c]){
                visited[c] = true;
                backtrack(list,visited,list[c]);
            }
        }
    }
}