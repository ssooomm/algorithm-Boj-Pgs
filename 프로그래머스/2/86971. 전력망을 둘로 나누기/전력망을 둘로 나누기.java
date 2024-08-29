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
            int a = bfs(graph, n, w[0], w[1]);
            answer = Math.min(answer, Math.abs(n-2*a));
        }
        return answer;
    }
    
    int bfs(Map<Integer,List<Integer>> graph, int n, int e, int pass){
        boolean[] visited= new boolean[n+1];
        visited[e] = true;
        visited[pass] = true;
        Queue<Integer> q = new ArrayDeque<>();
        q.add(e);
        
        int cnt = 1;
        while(!q.isEmpty()){
            int cur = q.remove();
            for(int g:graph.get(cur)){
                if(!visited[g]){
                    visited[g] = true;
                    q.add(g);
                    cnt++;
                }
            }
        }
        return cnt;
    }
}