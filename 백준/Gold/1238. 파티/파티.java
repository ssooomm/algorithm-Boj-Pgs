import java.util.*;
import java.io.*;

public class Main{
    static class Node implements Comparable<Node>{
        int e;
        int v;
        public Node(int e, int v){
            this.e = e;
            this.v = v;
        }
        
        @Override
        public int compareTo(Node o){
            return this.v - o.v;
        }
    }
    static int n,m,x;
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(st.nextToken());
        
        List<List<Node>> graph = new ArrayList<>();
        List<List<Node>> revgraph = new ArrayList<>();
        for(int i=0;i<=n;i++){
            graph.add(new ArrayList<>());
            revgraph.add(new ArrayList<>());
        }
        
        for(int i=0;i<m;i++){
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int t = Integer.parseInt(st.nextToken());
            graph.get(s).add(new Node(e,t));
            revgraph.get(e).add(new Node(s,t));
        }
        
        int[] res = djks(graph);
        int[] revres = djks(revgraph);
        
        int max = 0;
        for(int i=1;i<=n;i++){
            max = Math.max(max,res[i]+revres[i]);
        }
        System.out.println(max);
    }
    
    static int[] djks(List<List<Node>> graph){
        int[] dist = new int[n+1];
        Arrays.fill(dist,Integer.MAX_VALUE);
        dist[x] = 0;
        boolean[] visited = new boolean[n+1];
        
        Queue<Node> q = new PriorityQueue<>();
        q.add(new Node(x,0));
        
        while(!q.isEmpty()){
            Node cur = q.poll();
            if(!visited[cur.e]){
                visited[cur.e] = true;
                for(Node n:graph.get(cur.e)){
                    if(dist[n.e]>dist[cur.e]+n.v){
                        dist[n.e] = dist[cur.e]+n.v;
                        q.add(new Node(n.e,dist[n.e]));
                    }
                }
            }
        }
        return dist;
    }
}