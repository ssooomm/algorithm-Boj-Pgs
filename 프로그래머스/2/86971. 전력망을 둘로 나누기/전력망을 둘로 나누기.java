import java.util.*;

class Solution {
    public int solution(int n, int[][] wires) {
        int answer = Integer.MAX_VALUE;
        
        Map<Integer,List<Integer>> graph = new HashMap<>();
        
        
        for(int i=0;i<n-1;i++){
            for(int a=1;a<=n;a++){
                graph.put(a,new ArrayList<>());
            }
            for(int j=0;j<n-1;j++){
                if(i==j) continue;
                graph.get(wires[j][0]).add(wires[j][1]);
                graph.get(wires[j][1]).add(wires[j][0]);
            }
            // System.out.println(graph);
            // boolean[] visited = new boolean[n+1];
            Set<Integer> visited = new HashSet<>();
            dfs(graph, wires[i][0], visited);
            int x = visited.size();
            visited.clear();
            dfs(graph, wires[i][1], visited);
            int y = visited.size();
            int tmp = Math.abs(x-y);
            answer = Math.min(tmp, answer);
        }
        return answer;
    }
    
    void dfs(Map<Integer,List<Integer>> graph, int curr, Set<Integer> visited){
        visited.add(curr);
        for(Integer g:graph.get(curr)){
            if(!visited.contains(g)){
                dfs(graph, g, visited);
            }
        }
    }
}