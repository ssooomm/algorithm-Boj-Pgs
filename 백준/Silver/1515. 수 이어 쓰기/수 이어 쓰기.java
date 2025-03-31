import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        int pt = 0;
        int base = 0;
        
        while(true){
            base++;
            String tmp = String.valueOf(base); 
            for(int i=0;i<tmp.length();i++){ //10 -> 1,0
                if(tmp.charAt(i)==str.charAt(pt)) pt++;
                if(pt==str.length()){ //문자열 끝까지 완료 
                    System.out.println(base);
                    return;
                }
            }
        }
    }
}