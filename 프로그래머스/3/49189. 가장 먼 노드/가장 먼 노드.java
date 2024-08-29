import java.util.*;

class Solution {
    public int solution(int n, int[][] edge) {
        int answer = 0;
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for(int i=1;i<=n;i++){
            graph.put(i,new ArrayList<>());
        }
        for(int[] e:edge){
            graph.get(e[0]).add(e[1]);
            graph.get(e[1]).add(e[0]);
        }
        
        boolean[] visited = new boolean[n+1];
        Queue<int[]> q = new ArrayDeque<>();
        q.add(new int[]{1,0});
        visited[1] = true;
        int maxDist=0,cnt=0;
        
        while(!q.isEmpty()){
            int[] cur = q.remove();
            if(maxDist<cur[1]){
                maxDist = cur[1];
                cnt = 1;
            }else if(maxDist==cur[1]){
                cnt++;
            }
            
            for(int g:graph.get(cur[0])){
                if(!visited[g]){
                    visited[g] = true;
                    q.add(new int[]{g,cur[1]+1});
                }
            }
            
        }
        return cnt;
    }
}