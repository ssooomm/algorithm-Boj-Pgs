import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Map<String, Integer> map = new TreeMap<>();
        for(int i=0;i<n;i++){
            String str = br.readLine();
            String[] tmp = str.split("\\.");
            map.put(tmp[1],map.getOrDefault(tmp[1],0)+1);
        }
        
        StringBuilder sb = new StringBuilder();
        for(String x:map.keySet()){
            sb.append(x+" "+map.get(x)+"\n");
        }
        
        System.out.println(sb);
    }
}