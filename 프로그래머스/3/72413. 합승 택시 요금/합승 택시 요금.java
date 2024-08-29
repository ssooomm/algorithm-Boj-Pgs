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
    int INF = Integer.MAX_VALUE;   
    public int solution(int n, int s, int a, int b, int[][] fares) {
        int answer = 0;
        Map<Integer,List<Edge>> graph = new HashMap<>();
        for(int i=1;i<=n;i++){
            graph.put(i,new ArrayList<>());
        }
        for(int[] fare:fares){
            graph.get(fare[0]).add(new Edge(fare[1],fare[2]));
            graph.get(fare[1]).add(new Edge(fare[0],fare[2]));
        }
        
        int[] sD = dikstra(fares,graph,s,n);
        int[] aD = dikstra(fares,graph,a,n);
        int[] bD = dikstra(fares,graph,b,n);
        
        int minTime = INF;
        for(int i=1;i<=n;i++){
            int tmp = sD[i]+aD[i]+bD[i];
            minTime = Math.min(tmp,minTime);
        }
        return minTime;
    }
    
    public int[] dikstra(int[][] fares, Map<Integer,List<Edge>> graph, int st, int n){
        Queue<Edge> pq = new PriorityQueue<>();
        pq.add(new Edge(st,0));
        int[] costs = new int[n+1];
        Arrays.fill(costs,INF);
        costs[st] = 0;
        
        while(!pq.isEmpty()){
            Edge cur = pq.remove();
            if(cur.cost>costs[cur.node]) continue;
            for(Edge next: graph.get(cur.node)){
                int nextCost = costs[cur.node] + next.cost;
                if(nextCost<costs[next.node]){
                    costs[next.node] = nextCost;
                    pq.add(new Edge(next.node,nextCost));
                }
            }
        }
        
        return costs;
    }
}