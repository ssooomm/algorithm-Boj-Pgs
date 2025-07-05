import java.util.*;
import java.io.*;

public class Main{
    static int n,m;
    static int[] arr;
    static StringBuilder res = new StringBuilder();
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
        
        bt(new ArrayList<>(),0);
        System.out.println(res);
    }
    static void bt(List<Integer> list, int st){
        if(list.size()==m){
            for(int i:list){
                res.append(i+" ");
            }
            res.append("\n");
            return;
        }
        
        for(int i=st;i<n;i++){
            list.add(arr[i]);
            bt(list,i);
            list.remove(list.size()-1);
        }
    }
}