import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        String game = st.nextToken();
        int max=0;
        if(game.equals("Y")) max=1;
        else if(game.equals("F")) max=2;
        else if(game.equals("O")) max=3;
        
        Set<String> set = new HashSet<>();
        int cnt=0, ans=0;
        while(n-->0){
            String player = br.readLine();
            if(set.contains(player)) continue;
            else{
                set.add(player);
                cnt++;
                if(cnt==max){
                    cnt=0;
                    ans++;
                }
            }
        }
        System.out.println(ans);
    }
}