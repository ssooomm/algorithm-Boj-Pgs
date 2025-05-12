import java.util.*;
import java.io.*;

class Node{
    int val;
    int cost;
    Node(int val, int cost){
        this.val = val;
        this.cost = cost;
    }
}

public class Main{
    static boolean[] visited;
    static int max_idx=0,max=0;
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st;
        
        Map<Integer,List<Node>> tree = new HashMap<>();
        for(int i=0;i<=n;i++){
            tree.put(i,new ArrayList<>());
        }
        
        for(int i=0;i<n-1;i++){
            st = new StringTokenizer(br.readLine());
            int n1 = Integer.parseInt(st.nextToken());
            int n2 = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            
            tree.get(n1).add(new Node(n2,c));
            tree.get(n2).add(new Node(n1, c));
        }
        
        //부모로부터 가장 가중치 큰 노드 찾기
        visited = new boolean[n+1];
        visited[1] = true;
        dfs(tree,1,0);
        
        //그 노드로부터 가장 가중치 큰 게 큰 지름 
        visited = new boolean[n+1];
        visited[max_idx] = true;
        dfs(tree,max_idx,0);
        
        System.out.println(max);
        
    }
    
    static void dfs(Map<Integer,List<Node>> tree, int idx, int cost){
        if(max<cost){
            max = cost;
            max_idx = idx;
        }
        
        for(Node next:tree.get(idx)){
            if(!visited[next.val]){
                visited[next.val] = true;
                dfs(tree,next.val,cost+next.cost);
            }
        }
    }
}