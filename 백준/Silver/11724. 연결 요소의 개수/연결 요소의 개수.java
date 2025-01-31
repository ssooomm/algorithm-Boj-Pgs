import java.util.*;
import java.io.*;

public class Main{
    static int cnt=0;
    static boolean[] visited;
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        List<List<Integer>> list = new ArrayList<>();
        for(int i=0;i<=n;i++){
            list.add(new ArrayList<>());
        }
        for(int i=0;i<m;i++){
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            list.get(u).add(v);
            list.get(v).add(u);
        }

        visited = new boolean[n+1];
        for(int x=1;x<=n;x++){
            if(!visited[x]){
                cnt++;
                visited[x] = true;
                dfs(list,list.get(x));
            }
        }

        System.out.println(cnt);
    }

    static void dfs(List<List<Integer>> list, List<Integer> tmp){

        for(int i:tmp){
            if(!visited[i]){
                visited[i] = true;
                dfs(list,list.get(i));
            }
        }
    }
}