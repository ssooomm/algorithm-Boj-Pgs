import java.io.*;
import java.util.*;

class Node{
    int next;
    int cost;
    public Node(int next, int cost){
        this.next = next;
        this.cost = cost;
    }
}
public class Main {
    static Map<Integer, List<Node>> tree = new HashMap<>();

    public static int bfs(int st, int end, int n){
        Queue<Node> q = new ArrayDeque<>();
        boolean[] visited = new boolean[n+1];
        visited[st] = true;
        q.add(new Node(st,0));
        while(!q.isEmpty()){
            Node cur = q.remove();
            if(cur.next == end) return cur.cost;
            for(Node next:tree.get(cur.next)){
                if(!visited[next.next]){
                    visited[next.next] = true;
                    q.add(new Node(next.next,cur.cost+next.cost));
                }
            }
        }
        return -1;
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());


        for(int i=1;i<N;i++){
            st = new StringTokenizer(br.readLine()," ");
            int v = Integer.parseInt(st.nextToken());
            int n = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            tree.putIfAbsent(v, new ArrayList<>());
            tree.get(v).add(new Node(n,c));
            tree.putIfAbsent(n, new ArrayList<>());
            tree.get(n).add(new Node(v,c));
        }

        while(M-- >0){
            st = new StringTokenizer(br.readLine()," ");
            int n1 = Integer.parseInt(st.nextToken());
            int n2 = Integer.parseInt(st.nextToken());

            System.out.println(bfs(n1,n2,N));
        }
    }
}

