import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        String[] str = br.readLine().split(" ");
        int n = Integer.parseInt(str[0]);
        int m = Integer.parseInt(str[1]);
        
        Set<String> set = new HashSet<>();
        for(int i=0;i<n;i++){
            set.add(br.readLine());
        }
        
        for(int i=0;i<m;i++){
            String[] kwd = br.readLine().split(",");
            for(String k:kwd){
                if(set.contains(k)){
                    set.remove(k);
                }
            }
            sb.append(set.size()+"\n");
        }
        
        System.out.println(sb);
    }
}