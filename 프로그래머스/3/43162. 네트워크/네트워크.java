import java.util.*;

class Solution {
    public int solution(int n, int[][] computers) {
        int answer = 0;
        
        boolean[] v = new boolean[n];
        
        List<Integer>[] list = new ArrayList[n];
        for(int i=0;i<n;i++){
            list[i] = new ArrayList<>();
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(j==i) continue;
                if(computers[i][j]==1){
                    list[i].add(j);
                    list[j].add(i);
                }
            }
        }
        
        Queue<Integer> q = new ArrayDeque<>();
        for(int i=0;i<n;i++){
            if(!v[i]){
                answer++;
                q.add(i);
                v[i] = true;
                while(!q.isEmpty()){
                    int tmp = q.poll();
                    for(int x:list[tmp]){
                        if(!v[x]){
                            v[x] = true;
                            q.add(x);
                        }
                    }
                }
            }
        }
        
        
        
        
        
        return answer;
    }
}