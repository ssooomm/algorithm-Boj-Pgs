import java.util.*;

class Solution {
    public int solution(int n, int[][] wires) {
        int answer = Integer.MAX_VALUE;
        Map<Integer,List<Integer>> graph = new HashMap<>();
        for(int i=1;i<=n;i++){
            graph.put(i,new ArrayList<>());
        }
        for(int[] wire:wires){
            graph.get(wire[0]).add(wire[1]);
            graph.get(wire[1]).add(wire[0]);
        }
        
        for(int[] w:wires){
            int a = bfs(w[0],w[1],n,graph);
            answer = Math.min(answer,Math.abs(n-(2*a)));
        }
        return answer;
    }
    
    int bfs(int e, int pass, int n, Map<Integer,List<Integer>> graph){
        Queue<Integer> q = new ArrayDeque<>();
        q.add(e);
        boolean[] visited = new boolean[n+1];
        visited[e] = true;
        visited[pass] = true;
        int cnt = 1;
        while(!q.isEmpty()){
            int cur = q.remove();
            for(int next:graph.get(cur)){
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