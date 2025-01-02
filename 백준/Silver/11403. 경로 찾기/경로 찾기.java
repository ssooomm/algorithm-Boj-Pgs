import java.io.*;
import java.util.*;

public class Main {

    static int[][] matrix;
    static Map<Integer,List<Integer>> graph;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        matrix = new int[N][N];
        graph = new HashMap<>();

        for(int i=0;i<N;i++){
            graph.put(i,new ArrayList<>());
            String[] row = br.readLine().split(" ");
            for(int j=0;j<N;j++){
                if(Integer.parseInt(row[j])==1){
                    graph.get(i).add(j);
                }
            }
        }

        // 각 정점에서 탐색 진행
        for(int i=0;i<N;i++){
            bfs(i,N);
        }
        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                sb.append(matrix[i][j]+" ");
            }
            sb.append("\n");
        }

        System.out.println(sb);


    }

    public static void bfs(int st, int N){
        Queue<Integer> q = new ArrayDeque<>();
        boolean[] visited = new boolean[N];
        q.add(st);
        while(!q.isEmpty()){
            int curr = q.remove();
            for(Integer next:graph.get(curr)){
                if(!visited[next]){
                    visited[next] = true;
                    matrix[st][next] = 1;
                    q.add(next);
                }
            }
        }
    }


}
