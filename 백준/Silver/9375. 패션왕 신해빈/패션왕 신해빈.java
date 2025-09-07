import java.util.*;
import java.io.*;

public class Main{
    static Map<String,Integer> hm;
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int t = Integer.parseInt(br.readLine());
        while(t-->0){
            int n = Integer.parseInt(br.readLine());
            hm = new HashMap<>();
            for(int i=0;i<n;i++){
                st = new StringTokenizer(br.readLine());
                String a = st.nextToken();
                String b = st.nextToken();
                hm.put(b,hm.getOrDefault(b,0)+1);
            }
            int res=1;
            for(int x:hm.values()){
                res*=(x+1);
            }
            System.out.println(--res);
        }
        
        
    }
}