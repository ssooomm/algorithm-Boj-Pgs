import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        int[] dist = new int[n+1];
        Arrays.fill(dist,Integer.MAX_VALUE);
        
        List<int[]>[] list = new ArrayList[n+1];
        for(int i=1;i<=n;i++){
            list[i] = new ArrayList<>();
        }
        
        StringTokenizer st;
        while(m-->0){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            list[a].add(new int[]{b,c});
        }
        
        st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        
        Queue<int[]> pq = new PriorityQueue<>((x,y)->x[1]-y[1]);
        pq.add(new int[]{a,0});
        
        while(!pq.isEmpty()){
            int[] cur = pq.poll();
            int tmp = cur[0];
            int cost = cur[1];
            
            if(dist[tmp]<cost) continue;
            
            for(int[] next:list[tmp]){
                int ne = next[0];
                int nec = next[1];
                if(cost+nec<dist[ne]){
                    dist[ne] = cost+nec;
                    pq.add(new int[]{ne,dist[ne]});
                }
                
            }
        }
        
        System.out.println(dist[b]);
    }
}