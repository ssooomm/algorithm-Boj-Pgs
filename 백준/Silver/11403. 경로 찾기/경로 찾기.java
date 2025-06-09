import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st;
        
        List<List<Integer>> list = new ArrayList<>();
        for(int i=0;i<n;i++){
            list.add(new ArrayList<>());
        }
        for(int i=0;i<n;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<n;j++){
                int x = Integer.parseInt(st.nextToken());
                if(x==1){
                    list.get(i).add(j);
                }
            }
        }
        
        int[][] arr = new int[n][n];
        Queue<Integer> q;
        boolean[] visited;
        for(int i=0;i<n;i++){
            q = new ArrayDeque<>();
            q.add(i);
            visited = new boolean[n];
            while(!q.isEmpty()){
                int cur = q.poll();
                for(int l:list.get(cur)){
                    if(!visited[l]){
                        arr[i][l] = 1;
                        q.add(l);
                        visited[l] = true;
                    }
                }
            }
        }
        
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                sb.append(arr[i][j]+" ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}