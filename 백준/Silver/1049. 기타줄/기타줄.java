import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int set=1001;
        int one=1001;
        while(m-->0){
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int o = Integer.parseInt(st.nextToken());
            set = Math.min(set,s);
            one = Math.min(one,o);
        }
        
        int a = n/6;
        int b = n%6;
        int x = set*a;
        int xx = x+set;
        int y = x+(b*one);
        int yy = n*one;
        System.out.println(Math.min(Math.min(xx,y),yy));
    }
}