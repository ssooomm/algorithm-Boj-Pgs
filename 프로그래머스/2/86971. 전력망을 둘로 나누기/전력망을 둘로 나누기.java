import java.util.*;

class Solution {
    public int solution(int n, int[][] wires) {
        int answer = Integer.MAX_VALUE;
        Map<Integer,List<Integer>> graph = new HashMap<>();
        for(int i=1;i<=n;i++){
            graph.put(i,new ArrayList<>());
        }
        for(int[] w:wires){
            graph.get(w[0]).add(w[1]);
            graph.get(w[1]).add(w[0]);
        }
        
        for(int[] w:wires){
            // boolean[] v1= new boolean[n+1];
            // v1[w[1]] = true;
            // int n1 = bfs(w[0],w[1],n,graph,v1);
            boolean[] v1= new boolean[n+1];
            v1[w[1]] = true;
            int n1 = bfs(v1, graph,w[0]);
            
            // boolean[] v2= new boolean[n+1];
            // v2[w[0]] = true;
            // int n2 = bfs(v2,graph,w[1]);
            
            answer = Math.min(answer,Math.abs(n-2*n1));
        }
        return answer;
    }
    
    int bfs(boolean[] visited,Map<Integer,List<Integer>> graph, int st){
        Queue<Integer> q = new ArrayDeque<>();
        q.add(st);
        visited[st] = true;
        int cnt = 1;
        while(!q.isEmpty()){
            int target = q.remove();
            for(int next:graph.get(target)){
                if(!visited[next]){
                    visited[next] = true;
                    q.add(next);
                    cnt++;
                }
            }
        }
        
        return cnt;
    }
}