import java.util.*;

class Solution {
    public int solution(int n, int[][] edge) {
        List<Integer>[] list = new ArrayList[n+1];
        for(int i=1;i<=n;i++){
            list[i] = new ArrayList<>();
        }
        for(int[] e:edge){
            list[e[0]].add(e[1]);
            list[e[1]].add(e[0]);
        }
        int max = 0, cnt = 0;
        boolean[] visited = new boolean[n+1];
        Queue<int[]> q = new ArrayDeque<>();
        q.add(new int[]{1,0});
        visited[1] = true;
        
        while(!q.isEmpty()){
            int[] cur = q.remove();
            if(cur[1]>max){
                cnt = 1;
                max = cur[1];
            }else if(cur[1] == max) cnt++;
            for(int x:list[cur[0]]){
                if(!visited[x]){
                    q.add(new int[]{x,cur[1]+1});
                    visited[x] = true;
                }
            }
        }
        return cnt;
    }
}