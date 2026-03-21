import java.util.*;

class Solution {
    static int cnt=0;
    static List<Integer>[] list;
    static boolean[] v;
    public int solution(int n, int[][] wires) {
        int answer = Integer.MAX_VALUE;
        
        list = new ArrayList[n+1];
        v = new boolean[n+1];
        for(int i=0;i<=n;i++){
            list[i] = new ArrayList<>();
        }
        for(int[] w:wires){
            list[w[0]].add(w[1]);
            list[w[1]].add(w[0]);
        }
        
        for(int[] w:wires){
            cnt=0;
            Arrays.fill(v,false);
            v[w[0]] = true;
            v[w[1]] = true;
            dfs(w[0]);
            int a = cnt;
            cnt=0;
            Arrays.fill(v,false);
            v[w[0]] = true;
            v[w[1]] = true;
            dfs(w[1]);
            int b = cnt;
            answer = Math.min(answer,Math.abs(a-b));
            
        }
        
        return answer;
    }
    
    void dfs(int x){
        for(int i:list[x]){
            if(!v[i]){
                v[i] = true;
                cnt++;
                dfs(i);
            }
        }
        return;
    }
}