import java.util.*;
import java.io.*;

public class Main{
    static int[] pt; // 부모 저장 
    static class Node implements Comparable<Node>{
        int to;
        int from;
        int c;
        public Node(int to, int from,int c){
            this.to=to;
            this.from = from;
            this.c=c;
        }

        @Override
        public int compareTo(Node n){
            return this.c-n.c;
        }
    }
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int v = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());
        
        pt = new int[v+1];
        for(int i=1;i<=v;i++){
            pt[i] = i;
        }
        
        Queue<Node> pq = new PriorityQueue<>();
        for(int i=0;i<e;i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            pq.add(new Node(a,b,c));
        }
        
        int res=0;
        while(!pq.isEmpty()){
            Node cur = pq.poll();
            int to = find(cur.to);
            int from = find(cur.from);
            if(to!=from){
                res += cur.c;
                pt[from] = to;
            }
        }
       System.out.println(res);
    }
    
    //부모 노드 찾기
    static int find(int a){
        if(pt[a]==a) return a;
        return pt[a] = find(pt[a]); //pt값 갱신하면서 경로 압축 
    }
    
}