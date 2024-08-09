import java.util.*;

class Solution {
    public int solution(int n, int[][] edge) {
        int answer = 0;
        Map<Integer,List<Integer>> graph = new HashMap<>();
        for(int i=1;i<=n;i++){
            graph.put(i,new ArrayList<>());
        }
        for(int[] e:edge){
            graph.get(e[0]).add(e[1]);
            graph.get(e[1]).add(e[0]);
        }
        
        Queue<int[]> q = new ArrayDeque<>();
        boolean[] visited = new boolean[n+1];
        q.add(new int[]{1,0});
        visited[1] = true;
        
        int max=0,cnt=0;
        while(!q.isEmpty()){
            int[] cur = q.remove();
            if(cur[1]>max){
                max= cur[1];
                cnt = 1;
            }else if(cur[1]==max) cnt++;
            
            for(int next:graph.get(cur[0])){
                if(!visited[next]){
                    visited[next] = true;
                    q.add(new int[]{next,cur[1]+1});
                }
            }
        }
        
        
        return cnt;
    }
}