import java.util.*;
import java.io.*;

public class Main{
    static class Node implements Comparable<Node>{
        int e;
        int c;
        public Node(int e, int c){
            this.e = e;
            this.c = c;
        }
        @Override
        public int compareTo(Node o){
            return this.c - o.c;
        }
    }
    static List<List<Node>> graph;
    static int[] cost;
    static int[] prev;
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        
        graph = new ArrayList<>();
        for(int i=0;i<=n;i++){
            graph.add(new ArrayList<>());
        }
        
        StringTokenizer st;
        for(int i=0;i<m;i++){
            st = new StringTokenizer(br.readLine());
            int f = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            graph.get(f).add(new Node(e,c));
        }
        
        st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());
        cost = new int[n+1];
        Arrays.fill(cost,Integer.MAX_VALUE);
        prev = new int[n+1];
        
        djk(start);
        
        List<Integer> path = new ArrayList<>();
        for(int i=end;i!=0;i=prev[i]){
            path.add(i);
        }
        Collections.reverse(path);
        
        StringBuilder sb = new StringBuilder();
        sb.append(cost[end]+"\n");
        sb.append(path.size()+"\n");
        for(int i:path){
            sb.append(i+" ");
        }
        System.out.println(sb);
    }
    
    static void djk(int start){
        Queue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(start,0));
        cost[start] = 0;
        
        while(!pq.isEmpty()){
            Node cur = pq.poll();
            if(cost[cur.e]<cur.c) continue;
            
            for(Node n:graph.get(cur.e)){
                int next = cost[cur.e]+n.c;
                if(cost[n.e]>next){
                    cost[n.e] = next;
                    prev[n.e] = cur.e;
                    pq.add(new Node(n.e,next));
                }
            }
        }
    }
}