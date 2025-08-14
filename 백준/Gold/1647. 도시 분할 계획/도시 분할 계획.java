import java.util.*;
import java.io.*;


public class Main{
    static class Node implements Comparable<Node>{
        int to;
        int from;
        int cost;
        public Node(int to, int from, int cost){
            this.to = to;
            this.from = from;
            this.cost = cost;
        }
        @Override
        public int compareTo(Node o){
            return this.cost - o.cost;
        }
    }
    
    static int[] p;
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        
        Queue<Node> pq = new PriorityQueue<>();
        while(m-->0){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            pq.add(new Node(a,b,c));
        }
        
        p = new int[n+1];
        for(int i=1;i<=n;i++){
            p[i] = i;
        }
        
        int res=0;
        int bigcost = 0;
      
        while(!pq.isEmpty()){
            Node cur = pq.poll();
            int to = find(cur.to);
            int from = find(cur.from);
            if(to!=from){
                res+=cur.cost;
                bigcost = cur.cost;
                p[from] = to;
            }
        }
        System.out.println(res-bigcost);
    }
    
    static int find(int x){
        if(p[x]==x) return x;
        else return p[x] = find(p[x]);
    }
}