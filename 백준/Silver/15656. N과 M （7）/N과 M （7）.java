import java.util.*;
import java.io.*;

public class Main{
    static StringBuilder res =  new StringBuilder();
    static int n,m;
    static int[] arr;
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m= Integer.parseInt(st.nextToken());
        arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<n;i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        bt(new ArrayList<>());
        System.out.println(res);
    }
    
    static void bt(List<Integer> list){
        if(list.size()==m){
            for(int i:list){
                res.append(i+" ");
            }
            res.append("\n");
            return;
        }
        
        for(int i=0;i<n;i++){
            list.add(arr[i]);
            bt(list);
            list.remove(list.size()-1);
        }
    }
}