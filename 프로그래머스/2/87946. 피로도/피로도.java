import java.util.*;

class Solution {
    public int solution(int k, int[][] dungeons) {
        int answer = 0;
        int len = dungeons.length;
        List<List<Integer>> res = new ArrayList<>();
        boolean[] visited = new boolean[len+1];
        backtrack(len,visited,new ArrayList<>(), res);
        
        int max = 0;
        for(List<Integer> l:res){
            int tmp = k;
            int cnt = 0;
            for(int n: l){
                if(tmp>=dungeons[n-1][0]){
                    tmp-=dungeons[n-1][1];
                    cnt++;
                }
                else{
                    break;
                }
            }
            if(max<cnt){
                max = cnt;
            }
        }

        return max;
    }
    void backtrack(int n, boolean[] visited, List<Integer> cur, List<List<Integer>> res){
        if(cur.size() == n){
            res.add(new ArrayList<>(cur));
            return;
        }
        
        for(int i=1;i<=n;i++){
            if(!visited[i]){
                visited[i] = true;
                cur.add(i);
                backtrack(n,visited, cur, res);
                cur.remove(cur.size()-1);
                visited[i] = false;
            }
        }
    }
}