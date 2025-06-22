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
            return o.c-this.c;
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
            int c = Integer.parseInt(st.nextToken());
            graph.get(a).add(new Node(b,c));
            graph.get(b).add(new Node(a,c));
        }
        
        st = new StringTokenizer(br.readLine());
        int f = Integer.parseInt(st.nextToken());
        int l = Integer.parseInt(st.nextToken());
        
        boolean[] visited = new boolean[n+1];
        Queue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(f,Integer.MAX_VALUE));
        
        int max=0;
        while(!pq.isEmpty()){
            Node cur = pq.poll();
            if(visited[cur.e]) continue;
            visited[cur.e] = true;
            if(cur.e==l){
                max = cur.c;
                break;
            }
            for(Node next:graph.get(cur.e)){
                if(!visited[next.e]){
                    int cost = Math.min(cur.c,next.c);
                    pq.add(new Node(next.e,cost));
                }
            }
            
        }
        System.out.println(max);
    }
}