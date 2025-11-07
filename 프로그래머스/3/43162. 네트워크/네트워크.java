import java.util.*;

class Solution {
    static boolean[] v;
    static List<Integer>[] list;
    public int solution(int n, int[][] computers) {
        int answer = 0;
        v = new boolean[n+1];
        
        list = new ArrayList[n+1];
        for(int i=1;i<=n;i++){
            list[i] = new ArrayList<>();
        }
        
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(i==j) continue;
                if(computers[i][j]==1) {
                    list[i+1].add(j+1);
                    list[j+1].add(i+1);
                }
            }
        }
        
        int cnt=0;
        for(int i=1;i<=n;i++){
            if(!v[i]){
                v[i] = true;
                bfs(i);
                cnt++;
            }
        }
        return cnt;
    }
    
    static void bfs(int i){
        Queue<Integer> q = new ArrayDeque<>();
        q.add(i);
        while(!q.isEmpty()){
            int tmp = q.poll();
            for(int l:list[tmp]){
                if(!v[l]){
                    v[l] = true;
                    q.add(l);
                }
            }
        }
    }
}