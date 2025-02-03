import java.util.*;

public class Main{
    static class Edge implements Comparable<Edge>{
        int node;
        int cost;
        public Edge(int node, int cost){
            this.node = node;
            this.cost = cost;
        }

        @Override
        public int compareTo(Edge o){
            return this.cost - o.cost;
        }
    }
    static int n;
    static List<Edge>[] list;
    static int[] dist, conn;
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        int m = sc.nextInt();


        dist = new int[n+1];
        Arrays.fill(dist, Integer.MAX_VALUE);

        conn = new int[n+1];

        list = new ArrayList[n+1];
        for(int i=0;i<=n;i++){
            list[i] = new ArrayList<Edge>();
        }
        for(int i=0;i<m;i++){
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();

            list[a].add(new Edge(b,c));
            list[b].add(new Edge(a,c));
        }

        djks();
        int cnt = 0;

        StringBuilder sb = new StringBuilder();
        for(int i=2;i<=n;i++){
            if(conn[i]!=0){
                cnt++;
                sb.append(i+" "+conn[i]+"\n");
            }
        }
        System.out.println(cnt);
        System.out.println(sb);
    }

    static void djks(){

        dist[1] = 0;
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        pq.add(new Edge(1,0));
        while(!pq.isEmpty()){
            Edge edge = pq.poll();

            if(edge.cost > dist[edge.node]) continue;

            for(Edge e:list[edge.node]){
                if(dist[e.node]>e.cost+edge.cost){
                    dist[e.node] = e.cost+edge.cost;
                    conn[e.node] = edge.node;
                    pq.add(new Edge(e.node,dist[e.node]));
                }
            }
        }
    }
}