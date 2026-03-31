import java.util.*;

class Solution {
    public int solution(int N, int[][] road, int K) {
        int answer = 0;

        List<int[]>[] list = new ArrayList[N+1];
        for(int i=0;i<=N;i++){
            list[i] = new ArrayList<>();
        }
        for(int i=0;i<road.length;i++){
            int a = road[i][0];
            int b = road[i][1];
            int c = road[i][2];
            list[a].add(new int[]{b,c});
            list[b].add(new int[]{a,c});
        }
        
        int[] dist = new int[N+1];
        Arrays.fill(dist,Integer.MAX_VALUE);
        dist[1] =0;
        
        Queue<int[]> pq = new PriorityQueue<>((a,b)->a[1]-b[1]);
        pq.add(new int[]{1,0});
        while(!pq.isEmpty()){
            int[] cur = pq.poll();
            for(int[] n:list[cur[0]]){
                if(cur[1]+n[1]<dist[n[0]]){
                    dist[n[0]] = cur[1] + n[1];
                    pq.add(new int[]{n[0],dist[n[0]]});
                }
            }
        }
        
        for(int i=1;i<=N;i++){
            if(dist[i]<=K) answer++;
        }
        

        return answer;
    }
}