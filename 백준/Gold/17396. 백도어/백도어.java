import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        boolean[] visited = new boolean[n];

        st = new StringTokenizer(br.readLine());
        for(int i=0;i<n;i++){
            if(st.nextToken().equals("1")) visited[i] = true;
        }

        List<Node>[] graph = new ArrayList[n];
        for(int i=0;i<n;i++){ //0<=a,b<n
            graph[i] = new ArrayList<>();
        }
        for(int i=0;i<m;i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            long t = Integer.parseInt(st.nextToken());
            graph[a].add(new Node(b,t));
            graph[b].add(new Node(a,t));
        }

        long[] time = new long[n];
        Arrays.fill(time, Long.MAX_VALUE);
        time[0] = 0;
        
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(0,0));

        while(!pq.isEmpty()){
            Node cur = pq.poll();
            int e = cur.v;
            long t = cur.c;
            if(e==n-1) break;
            if(t>time[e]) continue;

            for(Node node:graph[e]){
                int ne = node.v;
                long nt = node.c + time[e];
                if(visited[ne]&&ne!=n-1) continue;
                if(time[ne]>nt){
                    time[ne] = nt;
                    pq.add(new Node(ne,nt));
                }
            }
        }

        long ans = time[n-1]==Long.MAX_VALUE?-1:time[n-1];
        System.out.println(ans);
    }

    static class Node implements Comparable<Node>{
        int v;
        long c;
        Node(int v,long c){
            this.v = v;
            this.c = c;
        }
        @Override
        public int compareTo(Node o){
            return Long.compare(this.c,o.c);
        }

    }
}