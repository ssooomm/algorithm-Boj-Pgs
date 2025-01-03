import java.util.*;
import java.io.*;

public class Main{
    static List<List<Integer>> tree, list;
    static int parent[], size[];
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());
        int Q = Integer.parseInt(st.nextToken());

        list = new ArrayList<>();
        tree = new ArrayList<>();
        parent = new int[N+1];
        size = new int[N+1];
        for(int i=0;i<=N;i++){
            list.add(new ArrayList<>());
            tree.add(new ArrayList<>());
        }
        for(int i=1;i<N;i++){
            st = new StringTokenizer(br.readLine());
            int U = Integer.parseInt(st.nextToken());
            int V = Integer.parseInt(st.nextToken());
            list.get(U).add(V);
            list.get(V).add(U);
        }
        makeTree(R,-1);
        cntSub(R);

        for(int i=0;i<Q;i++){
            int U = Integer.parseInt(br.readLine());
            System.out.println(size[U]);
        }
    }

    static void makeTree(int curr, int p){
        for(int n:list.get(curr)){
            if(n!=p){
                tree.get(curr).add(n);
                parent[n] = curr;
                makeTree(n,curr);
            }
        }
    }

    static void cntSub(int curr){
        size[curr] = 1;
        for(int n:tree.get(curr)){
            cntSub(n);
            size[curr]+=size[n];
        }
    }


}