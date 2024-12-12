import java.util.*;

class Solution {
    public int solution(int n, int[][] edge) {
        int answer = 0;
        boolean[] visited = new boolean[n+1];
        Map<Integer,List<Integer>> graph = new HashMap<>();
        for(int i=1;i<=n;i++){
            graph.put(i, new ArrayList<>());
        }
        for(int[] e: edge){
            graph.get(e[0]).add(e[1]);
            graph.get(e[1]).add(e[0]);
        }
        
        visited[1] = true;
        Queue<int[]> q = new ArrayDeque<>();
        q.add(new int[]{1,0});
        int maxD = 0, cnt = 0;
        while(!q.isEmpty()){
            int[] curr = q.remove();
            if(maxD<curr[1]){
                maxD = curr[1];
                cnt= 1;
            }else if(maxD==curr[1]){
                cnt++;
            }
            for(int g:graph.get(curr[0])){
                if(!visited[g]){
                    visited[g] = true;
                    q.add(new int[]{g, curr[1]+1});
                }
            }
            
        }
        
        
        
        
        return cnt;
    }
}