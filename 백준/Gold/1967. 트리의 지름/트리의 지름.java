import java.io.*;
import java.util.*;

class Node{
    int value;
    int cost;
    public Node(int value, int cost){
        this.value = value;
        this.cost = cost;
    }
}
public class Main {
    static int max_idx = 0;
    static int max = 0;
    static boolean[] visited;
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        Map<Integer, List<Node>> tree = new HashMap<>();
        for(int i=0;i<=N;i++){
            tree.put(i,new ArrayList<>());
        }

        for(int i=0;i<N-1;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n1 = Integer.parseInt(st.nextToken());
            int n2 = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            tree.get(n1).add(new Node(n2, c));
            tree.get(n2).add(new Node(n1, c));
        }

        visited = new boolean[N+1];
        visited[1] = true;
        dfs(tree,1,0);

        visited = new boolean[N+1];
        visited[max_idx] = true;
        dfs(tree,max_idx,0);
        System.out.println(max);

    }

    static void dfs(Map<Integer, List<Node>> tree, int idx, int cost){
        if(max<cost){
            max = cost;
            max_idx = idx;
        }

        for(Node next:tree.get(idx)){
            if(!visited[next.value]){
                visited[next.value] = true;
                dfs(tree, next.value,cost+next.cost);
            }
        }
    }
}
