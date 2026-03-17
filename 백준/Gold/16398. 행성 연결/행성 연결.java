import java.util.*;
import java.io.*;

public class Main{
    static class Node implements Comparable<Node>{
        int x;
        int y;
        int c;
        Node(int x,int y,int c){
            this.x=x;
            this.y=y;
            this.c=c;
        }
        @Override
        public int compareTo(Node o){
            return this.c-o.c;
        }
    }
    
    static int n;
    static int[] p;
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        
        Queue<Node> pq = new PriorityQueue<>();
        StringTokenizer st;
        for(int i=0;i<n;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<n;j++){
                int x = Integer.parseInt(st.nextToken());
                if(i<j)
                    pq.add(new Node(i,j,x));
            }
        }
        
        p = new int[n];
        for(int i=0;i<n;i++)
            p[i] = i;
        
        long sum=0;
        int cnt=0;
        
        while(!pq.isEmpty()){
            Node tmp = pq.poll();
            if(find(tmp.x)==find(tmp.y)) continue;
            
            union(tmp.x,tmp.y);
            sum+=tmp.c;
            cnt++;
            
            if(cnt==n-1) break;
        }
        System.out.println(sum);
    }

    static int find(int x){
        if(x==p[x]) return x;
        return p[x] = find(p[x]);
    }
    
    static void union(int x,int y){
        int rx = find(x);
        int ry = find(y);
        if(rx!=ry){
            p[ry] = rx;
        }
    }
}