import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int m = Integer.parseInt(br.readLine());
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int s=0;
        while(m-->0){
            st = new StringTokenizer(br.readLine());
            String str = st.nextToken();
            if(str.equals("all")){
                s=(1<<21)-1;
            }else if(str.equals("empty")){
                s=0;
            }else{
                int n = Integer.parseInt(st.nextToken());
                if(str.equals("add")){
                    s |= 1<<n;
                }else if(str.equals("remove")){
                    s &= ~(1<<n);
                }else if(str.equals("check")){
                    sb.append((s & (1<<n)) != 0 ? 1 : 0).append("\n");
                }else if(str.equals("toggle")){
                    s ^= 1<<n;
                }
            }
        }
        System.out.println(sb);
    }
}