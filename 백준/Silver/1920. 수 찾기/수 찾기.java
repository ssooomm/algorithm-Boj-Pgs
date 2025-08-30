import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[n];
        Set<Integer> set = new HashSet<>();
        for(int i=0;i<n;i++){
            set.add(Integer.parseInt(st.nextToken()));
        }
        int m = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<m;i++){
            if(set.contains(Integer.parseInt(st.nextToken()))){
                sb.append("1\n");
            }else{
                sb.append("0\n");
            }
            
        }
        System.out.println(sb);
    }
}