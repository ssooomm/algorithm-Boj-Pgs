import java.util.*;
import java.io.*;

public class Main{
    static int n;
    static List<List<int[]>> graph = new ArrayList<>();
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        
        for(int i=0;i<=n;i++){
            graph.add(new ArrayList<>());
        }
        for(int i=1;i<n;i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            graph.get(a).add(new int[]{b,c});
            graph.get(b).add(new int[]{a,c});
        }
        
        StringBuilder sb = new StringBuilder();
        while(m-->0){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            sb.append(bfs(a,b)+"\n");
        }
        System.out.println(sb);
    }
    
    static int bfs(int x, int y){
        Queue<int[]> q = new ArrayDeque<>();
        q.add(new int[]{x,0});
        boolean[] visited = new boolean[n+1];
        visited[x] = true;
        while(!q.isEmpty()){
            int[] cur = q.poll();
            if(cur[0]==y) return cur[1];
            else{
                for(int[] arr:graph.get(cur[0])){
                    if(!visited[arr[0]]){
                        q.add(new int[]{arr[0],cur[1]+arr[1]});
                        visited[arr[0]] = true;
                    }
                }
            }
        }
        return 0;
    }
}