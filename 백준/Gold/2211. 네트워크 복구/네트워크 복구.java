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

    static List<Edge>[] list;
    static int n;
    static int[] dist, conn;
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        int m = sc.nextInt();

        // 1~n까지 저장
        conn = new int[n+1];
        dist = new int[n+1];
        Arrays.fill(dist,Integer.MAX_VALUE);
        list = new ArrayList[n+1];
        for(int i=0;i<=n;i++){
            list[i] = new ArrayList<>();
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
        // 1 = 슈퍼 컴
        dist[1] = 0;
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        pq.add(new Edge(1,0));
        
        while(!pq.isEmpty()){
            Edge now = pq.poll();
            
            // 이미 저장된 거리보다 새로운 거리가 크면 더 이상 볼 필요x
            if(now.cost > dist[now.node]) continue;
            
            for(Edge e:list[now.node]){
                int newDist = e.cost + now.cost;
                
                //연결된 요소들의 거리 모두 확인해서 최소 거리 찾기
                if(dist[e.node]>newDist){
                    dist[e.node] = newDist;
                    pq.add(new Edge(e.node, newDist));
                    conn[e.node] = now.node;
                }
            }
        }
    }
}