import java.util.*;
import java.io.*;

public class Main{
    static Set<List<Integer>> res = new LinkedHashSet<>();
    static int n,m;
    static int[] arr;
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        arr = new int[n];
        for(int i=0;i<n;i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        bt(new ArrayList<>(), 0);
        
        StringBuilder sb = new StringBuilder();
        for(List<Integer> tmp:res){
            for(int i:tmp){
                sb.append(i+" ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
    
    static void bt(List<Integer> list,int st){
        if(list.size()==m){
            res.add(new ArrayList<>(list));
            return;
        }
        
        for(int i=st;i<n;i++){
            list.add(arr[i]);
            bt(list,i);
            list.remove(list.size()-1);
        }
    }
}