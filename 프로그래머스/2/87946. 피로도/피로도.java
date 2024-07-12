
class Solution {
    int answer = 0;
    public int solution(int k, int[][] dungeons) {
        int n = dungeons.length;
        boolean[] visited = new boolean[n];
        backtrack(n,k,visited, 0,dungeons);
        return answer;
    }

    public void backtrack(int n, int k, boolean[] visited, int cnt, int[][] dungeons) {
        if(cnt > answer){
            answer = cnt;
        }
        for(int i = 0; i < n; i++){
            if(visited[i]) continue;

            int least = dungeons[i][0];
            int need = dungeons[i][1];

            if(k>=least){
                visited[i] = true;
                k-=need;
                backtrack(n,k,visited,cnt+1,dungeons);
                k+=need;
                visited[i] = false;
            }

        }
    }

}