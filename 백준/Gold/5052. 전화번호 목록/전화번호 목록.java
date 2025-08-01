import java.util.*;
import java.io.*;

public class Main{
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
            Arrays.sort(str); //911, 911345
            if(check(str)){
                res.append("YES\n");
            } 
            else res.append("NO\n");
        }
        System.out.println(res);
    }
    
    static boolean check(String[] str){
        for(int x=0;x<str.length-1;x++){
            if(str[x+1].startsWith(str[x])){
                return false;
            }
        }
        return true;
    }
}