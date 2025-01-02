import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        List<List<Integer>> tree = new ArrayList<>();

        for(int i=0;i<N;i++){
            tree.add(new ArrayList<>());
        }
        for(int i=1;i<N;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            // 인덱스 0부터 시작
            int n1 = Integer.parseInt(st.nextToken())-1;
            int n2 = Integer.parseInt(st.nextToken())-1;
            tree.get(n1).add(n2);
            tree.get(n2).add(n1);
        }

        boolean[] visited = new boolean[N];
        int[] parents = new int[N];

        Queue<Integer> q = new ArrayDeque<>();
        q.add(0);
        visited[0] = true;
        while(!q.isEmpty()){
            int curr = q.remove();
            for(int next:tree.get(curr)){
                if(!visited[next]){
                    // 처음 방문하는 노드가 부모 노드임
                    visited[next] = true;
                    q.add(next);
                    parents[next] = curr;
                }
            }
        }

        // 2번째 노드부터 출력 -> 인덱스 1
        for(int i=1;i<N;i++){
            System.out.println(parents[i]+1);
        }
    }
}