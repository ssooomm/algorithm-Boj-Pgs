import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());
        
        List<List<int[]>> graph = new ArrayList<>();
        for(int i=0;i<=d;i++){
            graph.add(new ArrayList<>());
        }
        
        for(int i=0;i<n;i++){
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int len = Integer.parseInt(st.nextToken());
            if(end>d) continue;
            if(end-start<len) continue;
            graph.get(start).add(new int[]{end,len});
        }
        
        int[] dist = new int[d+1]; //가중치 기록용
        Arrays.fill(dist,Integer.MAX_VALUE);
        dist[0] = 0;
        
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a->a[1]));
        pq.add(new int[]{0,0}); //현재 위치, 현재 비용
        
        while(!pq.isEmpty()){
            int[] cur = pq.remove();
            if(cur[1]>dist[cur[0]]) continue;
            
            int next_idx = cur[0] + 1;
            int next_d = cur[1] + 1;
            if(next_idx<=d && next_d<dist[next_idx]){
                dist[next_idx] = next_d;
                pq.add(new int[]{next_idx,next_d});
            }
            
            for(int[] edge:graph.get(cur[0])){
                int sh_idx = edge[0];
                int sh_d = cur[1]+edge[1];
                if(sh_d<dist[sh_idx]){
                    dist[sh_idx] = sh_d;
                    pq.add(new int[]{sh_idx,sh_d});
                }
            }
        }
        System.out.println(dist[d]);
    }
}