import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        
        String[] str = br.readLine().split(" ");
        int[] arr = new int[n];
        Set<Integer> set = new TreeSet<>();
        Map<Integer,Integer> map = new TreeMap<>();
        for(int i=0;i<n;i++){
            arr[i] = Integer.parseInt(str[i]);
            set.add(arr[i]);
        }
        int idx=0;
        for(int k:set){
            map.put(k,idx++);
        }
        
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<n;i++){
            sb.append(map.get(arr[i])+" ");
        }
        
        System.out.println(sb);
    }
}