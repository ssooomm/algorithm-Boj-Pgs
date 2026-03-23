import java.util.*;
import java.io.*;

public class Main{
    static List<int[]>[] list;
    static int n;
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());
        list= new ArrayList[n+1];
        for(int i=0;i<=n;i++){
            list[i] = new ArrayList<>();
        }
        for(int i=0;i<e;i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            list[a].add(new int[]{b,c});
            list[b].add(new int[]{a,c});
        }
        st = new StringTokenizer(br.readLine());
        int v1 = Integer.parseInt(st.nextToken());
        int v2 = Integer.parseInt(st.nextToken());
        
        while(true){
            int x = bfs(v1,v2);
            if(x==-1) break;
            int y = bfs(1,v1);
            if(y==-1) break;
            int y2 = bfs(v2,n);
            if(y2==-1) break;
            int z = bfs(1,v2);
            if(z==-1) break;
            int z2 = bfs(v1,n);
            if(z2==-1) break;
            
            int sum1 = y+y2+x;
            int sum2 = z+z2+x;
            System.out.println(Math.min(sum1,sum2));
            return;
        }
        System.out.println(-1);
        return;
    }
    
    static public int bfs(int st,int end){
        boolean[] v = new boolean[n+1];
        Queue<int[]> pq = new PriorityQueue<>((a,b)->a[1]-b[1]);
        pq.add(new int[]{st,0});
        while(!pq.isEmpty()){
            int[] cur = pq.poll();
            if(cur[0]==end) return cur[1];
            v[cur[0]] = true;
            for(int[] i:list[cur[0]]){
                if(!v[i[0]]){
                    pq.add(new int[]{i[0],cur[1]+i[1]});
                }
            }
        }
        return -1;
    }
}