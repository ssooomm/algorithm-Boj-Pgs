import java.util.*;
import java.io.*;



public class Main{
    static int n,m,k;
    static int[] parent;
    
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        parent = new int[n+1];
        
        
        
        Queue<int[]> graph = new PriorityQueue<>((a,b)->a[2]-b[2]);
        
        for(int i=0;i<m;i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph.add(new int[]{a,b,i+1});
        }
        
        boolean flag = false;
        StringBuilder sb = new StringBuilder();
        while(k-->0){
            if(flag){
                sb.append("0 ");
                continue;
            }
            for(int i=0;i<=n;i++){
                parent[i] = i;
            }
            Queue<int[]> pq = new PriorityQueue<>(graph);
            int sum=0,cnt=0;
            while(!pq.isEmpty()){
                int[] cur = pq.poll();
                if(find(cur[0])!=find(cur[1])){
                    union(cur[0],cur[1]);
                    sum+=cur[2];
                    cnt++;
                }
            }
            if(cnt != n-1){
                sb.append(0).append(" ");
                flag = true;
                continue;
            }
            sb.append(sum).append(" ");
            graph.poll();
        }
        
        System.out.println(sb);
    }
    
    public static int find(int x){
        if(parent[x]==x) return x;
        else{
            return parent[x] = find(parent[x]);
        }
    }
    
    public static void union(int a, int b){
        int pa = find(a);
        int pb = find(b);
        if(pa!=pb) parent[pa] = parent[pb];
    }
}