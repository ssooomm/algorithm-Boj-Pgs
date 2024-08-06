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
        
        for(int[] i:wires){
            int a = bfs(i[0],n,graph,i[1]);
            int b = bfs(i[1],n,graph,i[0]);
            answer = Math.min(answer,Math.abs(a-b));
        }
        return answer;
    }
    
    int bfs(int e, int n, Map<Integer,List<Integer>> graph, int pass){
        Queue<Integer> q = new ArrayDeque<>();
        boolean[] visited = new boolean[n+1];
        q.add(e);
        visited[e] = true;
        int cnt=0;
        while(!q.isEmpty()){
            int cur = q.remove();
            for(int ne:graph.get(cur)){
                if(!visited[ne] && ne!=pass){
                    visited[ne] =true;
                    q.add(ne);
                    cnt++;
                }
            }
        }
        return cnt;
    }
}