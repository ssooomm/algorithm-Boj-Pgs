import java.util.*;
import java.io.*;

public class Main{
    static int[] p;
    static class Node implements Comparable<Node>{
        int to;
        int from;
        int v;
        public Node(int to, int from, int v){
            this.to = to;
            this.from = from;
            this.v = v;
        }
        
        @Override
        public int compareTo(Node o){
            return this.v-o.v;
        }
    }
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int v = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());
        
        Queue<Node> pq = new PriorityQueue<>();
        for(int i=0;i<e;i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            pq.add(new Node(a,b,c));
        }
        
        p = new int[v+1];
        for(int i=1;i<=v;i++){
            p[i] = i; // 각 노드 초기화는 자기 자신이 root
        }
        
        int res = 0;
        while(!pq.isEmpty()){
            Node cur = pq.poll();
            int to = find(cur.to);
            int from = find(cur.from);
            if(to!=from){
                res+=cur.v;
                p[from] = to;
            }
        }
        
        System.out.println(res);
    }
    
    static int find(int x){
        if(p[x]==x) return x;
        else return p[x] = find(p[x]);
    }
}