import java.util.*;
import java.io.*;

public class Main{
    static List<List<Integer>> list;
    static boolean[] visited;
    static StringBuilder sb;
    
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int v = Integer.parseInt(st.nextToken());
        list = new ArrayList<>();
        
        for(int i=0;i<=n;i++){
            list.add(new ArrayList<>());
        }
        
        for(int i=0;i<m;i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            list.get(a).add(b);
            list.get(b).add(a);
        }

        for(int i=1;i<=n;i++){
            Collections.sort(list.get(i));
        }
        
        
        sb = new StringBuilder();
        visited = new boolean[n+1];
        dfs(v);
        System.out.println(sb);
        
        sb = new StringBuilder();
        visited = new boolean[n+1];
        bfs(v);
        System.out.println(sb);
    }
    static void dfs(int i){
        sb.append(i+" ");
        visited[i] = true;
        for(int j:list.get(i)){
            if(!visited[j]){
                dfs(j);
            }
        }
    }
    
    static void bfs(int i){
        Queue<Integer> q = new ArrayDeque<>();
        sb.append(i+" ");
        q.add(i);
        visited[i] = true;
        while(!q.isEmpty()){
            for(int j:list.get(q.poll())){
                if(!visited[j]){
                    q.add(j);
                    visited[j] = true;
                    sb.append(j+" ");
                }
            }
        }
    }
}