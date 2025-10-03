import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] pattern = br.readLine().split("\\*");
        String st = pattern[0];
        String end = pattern[1];
        StringBuilder sb = new StringBuilder();
        while(n-->0){
            String tmp = br.readLine();
            boolean flag = false;
            if(tmp.length()<st.length()+end.length()){
                sb.append("NE\n");
                continue;
            }
            if(!tmp.substring(0,st.length()).equals(st)){
                sb.append("NE\n");
                continue;
            }
            if(tmp.substring(tmp.length()-end.length()).equals(end))
                sb.append("DA\n");
            else sb.append("NE\n");
        }
        System.out.println(sb);
    }
}