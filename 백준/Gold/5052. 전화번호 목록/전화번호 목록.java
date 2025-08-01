import java.util.*;
import java.io.*;

public class Main{
    static Set<String> set;
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringBuilder res = new StringBuilder();
        while(t-->0){
            int n = Integer.parseInt(br.readLine());
            String[] str = new String[n];
            for(int i=0;i<n;i++){
                str[i] = br.readLine();
            }
            Arrays.sort(str,(a,b)->a.length()-b.length());
            set = new HashSet<>();
            set.add(str[0]);
            boolean flag = true;
            for(int i=1;i<n;i++){
                if(check(str[i])){
                    set.add(str[i]);
                }else{
                    flag = false;
                    break;
                }
            }
            if(flag) res.append("YES\n");
            else res.append("NO\n");
        }
        System.out.println(res);
    }
    
    static boolean check(String str){
        StringBuilder sb = new StringBuilder();
        for(int x=0;x<str.length();x++){
            sb.append(str.charAt(x));
            if(set.contains(sb.toString())){
                return false;
            }
        }
        return true;
    }
}