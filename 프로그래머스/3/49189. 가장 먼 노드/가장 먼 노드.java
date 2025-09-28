import java.util.*;

class Solution {
    public int solution(int n, int[][] edge) {
        int answer = 0;
        List<Integer>[] list = new ArrayList[n+1];
        for(int i=0;i<=n;i++){
            list[i] = new ArrayList<>();
        }
        for(int[] e:edge){
            list[e[0]].add(e[1]);
            list[e[1]].add(e[0]);
        }
        
        int max=0,cnt=0;
        boolean[] v = new boolean[n+1];
        Queue<int[]> q = new ArrayDeque<>();
        q.add(new int[]{1,0});
        v[1] = true;
        
        while(!q.isEmpty()){
            int[] tmp = q.poll();
            if(tmp[1]>max){
                cnt=1;
                max = tmp[1];
            }else if(tmp[1]==max) cnt++;
            
            for(int x:list[tmp[0]]){
                if(!v[x]){
                    v[x] = true;
                    q.add(new int[]{x,tmp[1]+1});
                }
            }
        }
        return cnt;
    }
}