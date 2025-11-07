import java.util.*;

class Node implements Comparable<Node>{
    int n;
    int fare;
    Node(int n, int fare){
        this.n = n;
        this.fare = fare;
    }
    
    @Override
    public int compareTo(Node o){
        return this.fare - o.fare;
    }
}
class Solution {
    static List<Node>[] list;
    public int solution(int n, int s, int a, int b, int[][] fares) {
        int answer = 0;
        list= new ArrayList[n+1];
        for(int i=1;i<=n;i++){
            list[i] = new ArrayList<>();
        }
        for(int[] f:fares){
            list[f[0]].add(new Node(f[1],f[2]));
            list[f[1]].add(new Node(f[0],f[2]));
        }
        
        int[] sD = dijk(s,n);
        int[] aD = dijk(a,n);
        int[] bD = dijk(b,n);
        
        int min=Integer.MAX_VALUE;
        for(int i=1;i<=n;i++){
            int tmp = sD[i]+aD[i]+bD[i];
            min = Math.min(tmp,min);
        }
        
        
        return min;
    }
    
    int[] dijk(int st, int n){
        Queue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(st,0));
        int[] fare = new int[n+1];
        Arrays.fill(fare,Integer.MAX_VALUE);
        fare[st] = 0;
        
        while(!pq.isEmpty()){
            Node cur = pq.poll();
            if(cur.fare>fare[cur.n]) continue;
            
            for(Node node:list[cur.n]){
                int nf = fare[cur.n]+node.fare;
                if(nf<fare[node.n]){
                    fare[node.n] = nf;
                    pq.add(new Node(node.n,nf));
                }
            }
        }
        return fare;
    }
}