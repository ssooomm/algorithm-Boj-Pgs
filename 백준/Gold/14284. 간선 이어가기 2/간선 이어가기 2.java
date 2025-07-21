import java.util.*;
import java.io.*;

public class Main{
    static class Node implements Comparable<Node>{
        int n;
        int v;
        public Node(int n, int v){
            this.n = n;
            this.v = v;
        }
        
        @Override
        public int compareTo(Node o){
            return this.v - o.v;
        }
    }
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        
        List<List<Node>> graph = new ArrayList<>();
        for(int i=0;i<=n;i++){
            graph.add(new ArrayList<>());
        }
        
        for(int i=0;i<m;i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            graph.get(a).add(new Node(b,v));
            graph.get(b).add(new Node(a,v));
        }
        st = new StringTokenizer(br.readLine());
        int f = Integer.parseInt(st.nextToken());
        int l = Integer.parseInt(st.nextToken());
        
        Queue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(f,0));
        boolean[] visited = new boolean[n+1];
        int[] dist = new int[n+1];
        Arrays.fill(dist,Integer.MAX_VALUE);
        dist[f] = 0;
        
        while(!pq.isEmpty()){
            Node cur = pq.poll();
            if(visited[cur.n]) continue;
            visited[cur.n] = true;
            
            if(cur.n==l) break;
            
            for(Node next:graph.get(cur.n)){
                if(!visited[next.n]){
                    int tmp = dist[cur.n]+next.v;
                    if(dist[next.n]>tmp){
                        dist[next.n] = tmp;
                        pq.add(new Node(next.n,tmp));
                    }
                }
            }
        }
        
        System.out.println(dist[l]);
    }
}