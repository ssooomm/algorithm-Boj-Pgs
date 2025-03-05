import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while(t-->0){
            String str = br.readLine();
            Map<Character,Integer> map = new HashMap<>();
            int max = 0;
            char max_ch = '?';
            for(int i=0;i<str.length();i++){
                char c = str.charAt(i);
                if((int)c>=97){
                    int cnt = map.getOrDefault(c,0)+1;
                    if(max<cnt){
                        max = cnt;
                        max_ch = c;
                    }else if(max==cnt){
                        max_ch = '?';
                    }
                    map.put(c,cnt);
                }
            }
            System.out.println(max_ch);
        }
    }
}