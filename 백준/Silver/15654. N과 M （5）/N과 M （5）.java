import java.util.*;
import java.io.*;

public class Main{
    static StringBuilder res = new StringBuilder();
    static int n,m;
    static int[] arr;
    static boolean[] visited;
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        arr = new int[n];
        visited = new boolean[n];
        for(int i=0;i<n;i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        backtrack(new ArrayList<>());
        System.out.println(res);
    }
    
    static void backtrack(List<Integer> list){
        if(list.size()==m){
            for(int i:list){
                res.append(i+" ");
            }
            res.append("\n");
            return;
        }
        
        for(int i=0;i<n;i++){
            if(!visited[i]){
                visited[i] = true;
                list.add(arr[i]);
                backtrack(list);
                visited[i] = false;
                list.remove(list.size()-1);
            }
        }
    }
}