import java.util.*;
import java.io.*;

public class Main{
    static int n,m;
    static int[] arr;
    static boolean[] visited;
    static Set<List<Integer>> res = new LinkedHashSet<>();
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
        
        bt(new ArrayList<>());
        
        StringBuilder sb = new StringBuilder();
        for(List<Integer> tmp:res){
            for(int i:tmp){
                sb.append(i+" ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
        
    }
    
    static void bt(List<Integer> list){
        if(list.size()==m){
            res.add(new ArrayList<>(list));
            return;
        }
        
        for(int i=0;i<n;i++){
            if(!visited[i]){
                visited[i] = true;
                list.add(arr[i]);
                bt(list);
                visited[i] = false;
                list.remove(list.size()-1);
            }
        }
    }
}