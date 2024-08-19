import java.util.*;

class Edge implements Comparable<Edge>{
    int node, cost;
    public Edge(int node, int cost){
        this.node = node;
        this.cost = cost;
    }
    
    @Override
    public int compareTo(Edge other){
        return Integer.compare(this.cost, other.cost);
    }
}

class Solution {
    public int solution(int n, int s, int a, int b, int[][] fares) {
        Map<Integer,List<Edge>> graph = new HashMap<>();
        for(int i=1;i<=n;i++){
            graph.put(i,new ArrayList<>());
        }
        for(int[] fare:fares){
            int n1 = fare[0];
            int n2 = fare[1];
            int w = fare[2];
            graph.get(n1).add(new Edge(n2,w));
            graph.get(n2).add(new Edge(n1,w));
        }
        
        int[] sDist = dijkstra(graph, s, n);
        int[] aDist = dijkstra(graph, a, n);
        int[] bDist = dijkstra(graph, b, n);
        
        int minC = Integer.MAX_VALUE;
        
        for(int i=1;i<=n;i++){
            int cost = sDist[i]+aDist[i]+bDist[i];
            minC = Math.min(minC, cost);
        }
        
        return minC;
    }
    
    int[] dijkstra(Map<Integer,List<Edge>> graph, int s, int n){
        int INF = Integer.MAX_VALUE;
        int[] costs = new int[n+1];
        Arrays.fill(costs,INF);
        
        Queue<Edge> pq = new PriorityQueue<>();
        pq.add(new Edge(s,0));
        costs[s] = 0;
        
        while(!pq.isEmpty()){
            Edge cur = pq.remove();
            if(costs[cur.node]<cur.cost) continue;
            
            for(Edge next: graph.get(cur.node)){
                int nextC = costs[cur.node]+next.cost;
                if(nextC < costs[next.node]){
                    pq.add(new Edge(next.node, nextC));
                    costs[next.node] = nextC;
                }
            }
        }
        
        return costs;
        
    }
}